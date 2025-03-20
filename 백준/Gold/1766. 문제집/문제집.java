import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer>[] graph;
	static int[] connected;
	static int N;
	static int M;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk =new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		
		graph = new ArrayList[N+1];
		connected = new int[N+1];
		
		for(int i = 0; i <= N; ++i) {
			graph[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < M; ++i) {
			stk = new StringTokenizer(br.readLine());
			int front = Integer.parseInt(stk.nextToken());
			int back = Integer.parseInt(stk.nextToken());
			
			graph[front].add(back);
			connected[back]++;
		}
		
		topologicalSort();
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush();
	}
	
	private static void topologicalSort() {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for(int i = 1; i <= N; ++i) {
			if(connected[i] == 0) {
				queue.add(i);
			}
		}
		
		while (!queue.isEmpty()) {
			int num = queue.poll();
			
			sb.append(num).append(" ");
			
			for (int n : graph[num]) {
				connected[n]--;
				
				if(connected[n] == 0) {
					queue.add(n);
				}
			}
		}
		
	}
}
