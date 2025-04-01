import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= 10; ++tc) {
			sb.append("#").append(tc).append(" ");
			
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(stk.nextToken());
			int E = Integer.parseInt(stk.nextToken());
			
			ArrayList<Integer>[] graph = new ArrayList[V+1];
			int[] indegrees = new int[V+1];
			for(int i = 1; i <= V; ++i) {
				graph[i] = new ArrayList<>();
			}
			
			stk = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < E; ++i ) {
				int node = Integer.parseInt(stk.nextToken());
				int to = Integer.parseInt(stk.nextToken());
				
				graph[node].add(to);
				indegrees[to]++;
			}
			
			topologicalSort(sb, graph, indegrees);
			sb.append("\n");
		}	
		
		System.out.println(sb.toString());
	}
	
	private static void topologicalSort(StringBuilder sb, ArrayList<Integer>[] graph, int[] indegrees) {
		Queue<Integer> queue = new ArrayDeque<>();
		
		for(int i = 1; i < indegrees.length; ++i) {
			if(indegrees[i] == 0) {
				queue.add(i);
				sb.append(i).append(" ");
			}
		}
		
		while (!queue.isEmpty()) {
			int curr = queue.poll();
			
			for (int to : graph[curr]) {
				indegrees[to]--;
				
				if(indegrees[to] == 0) {
					queue.add(to);
					sb.append(to).append(" ");
				}
			}
		}
	}
}
