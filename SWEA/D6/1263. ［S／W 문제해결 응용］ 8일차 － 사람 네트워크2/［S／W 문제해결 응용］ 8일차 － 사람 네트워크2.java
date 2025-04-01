import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= T; ++tc) {
			sb.append("#").append(tc).append(" ");
			
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(stk.nextToken());
			ArrayList<Integer>[] graph = new ArrayList[N];
			for(int i = 0; i < N; ++i) {
				graph[i] = new ArrayList<>();
			}
			
			for(int i = 0; i < N; ++i) {
				for(int j = 0; j < N; ++j) {
					int num = Integer.parseInt(stk.nextToken());
					if(num != 0) {
						graph[i].add(j);
						graph[j].add(i);
					}
				}
			}
			
			int min = Integer.MAX_VALUE;
			for(int i = 0; i < N; ++i) {
				min = Math.min(min, bfs(graph, i));
			}
			
			
			
			sb.append(min).append("\n");
		}	
		
		System.out.println(sb.toString());
	}
	
	private static int bfs(ArrayList<Integer>[] graph, int start) {
		boolean visited[] = new boolean[graph.length];
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.add(start);
		visited[start] = true;
		
		int dist = 0;
		int depth = -1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			
			for(int i = 0; i < size; ++i) {
				int curr = queue.poll();
				
				for (int node : graph[curr]) {
					if(visited[node]) continue;
					queue.add(node);
					visited[node] = true;
				}
			}
			
			dist += ++depth*size;
		}
		
		return dist;
	}
}
