import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer>[] graph;
	static int[] connected;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		
		graph = new ArrayList[N+1];
		connected = new int[N+1];
		
		for(int i = 0; i <= N; ++i) {
			graph[i] = new ArrayList<Integer>();
		}
		
		
		for(int i = 0; i < M; ++i) {
			stk = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(stk.nextToken());
			int to = Integer.parseInt(stk.nextToken());
			
			graph[start].add(to);
			connected[to]++;
		}
		
		topologicalSort();
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush();
	}
	
	private static StringBuilder sb = new StringBuilder();
	private static void topologicalSort() {
		Queue<Integer> queue = new ArrayDeque<>();
		
		for(int i = 1; i <= N; ++i) {
			if(connected[i] == 0) {
				queue.add(i);
				sb.append(i).append(" ");
			}	
		}
		
		while (!queue.isEmpty()) {
			int curr = queue.poll();
			
			for (int num : graph[curr]) {
				connected[num]--;
				
				if(connected[num] == 0) {
					queue.add(num);
					sb.append(num).append(" ");
				}
			}
		}
	} 
	
}
