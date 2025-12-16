import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	
	static ArrayList<Integer>[] graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		
		graph = new ArrayList[N+1];
		
		for(int i = 0; i <= N; ++i) {
			graph[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < M; ++i) {
			stk = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(stk.nextToken());
			int B = Integer.parseInt(stk.nextToken());
			
			graph[B].add(A);
		}
		
		ArrayList<Integer> answer = new ArrayList<>();
		int maxNum = 0;
		for(int i = 1; i <= N; ++i) {
			int curr = bfs(i);
			
			if(curr > maxNum) {
				answer.clear();
				answer.add(i); 
				maxNum = curr;
			}
			else if(curr == maxNum) {
				answer.add(i);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int ans : answer) {
			sb.append(ans).append(" ");
		}
		System.out.println(sb);
	}
	
	private static int bfs(int start) {
		boolean[] visited = new boolean[10001];
		visited[start] = true;
		
		Queue<Integer> dq = new ArrayDeque<>();
		dq.add(start);
		
		int hacked = 0;
		
		while (!dq.isEmpty()) {
			int curr = dq.poll();
			
			for(int next : graph[curr]) {
				if(visited[next]) continue;
				
				visited[next] = true;
				hacked++;
				
				dq.add(next);
			}
		}
		
		return hacked;
	}
}
