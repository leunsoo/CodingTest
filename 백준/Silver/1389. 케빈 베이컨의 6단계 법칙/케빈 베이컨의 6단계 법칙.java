import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer>[] graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		int N = Integer.parseInt(strs[0]);
		int M = Integer.parseInt(strs[1]);
		
		graph = new ArrayList[N+1];

		for(int i = 0; i <= N; ++i) {
			graph[i] = new ArrayList<Integer>();
		}

		StringTokenizer stk;		
		for(int i = 0; i < M; ++i) {
			stk = new StringTokenizer(br.readLine());
			int idx =Integer.parseInt(stk.nextToken());
			int connect = Integer.parseInt(stk.nextToken());
			graph[idx].add(connect);
			graph[connect].add(idx);
		}
		
		int min = Integer.MAX_VALUE;
		int answer = 0;
		for(int i = 1; i <= N; ++i) {
			int num = bfs(i, N);
			
			if(min > num) {
				min = num;
				answer = i;
			}
		}
		
		System.out.println(answer);
	}
	
	private static int bfs(int idx, int N) {
		int sum = 0;
		
		
		for(int i = 1; i <= N; ++i) {
			if(i == idx) continue;
			boolean[] visited = new boolean[N+1];
			
			Queue<int[]> queue = new ArrayDeque<int[]>();
			queue.add(new int[] {idx, 0});
			visited[idx] = true;
			
			while (!queue.isEmpty()) {
				int curr[] = queue.poll();
				
				if(curr[0] == i) {
					sum += curr[1];
					break;
				}
				
				for(int j = 0; j < graph[curr[0]].size(); ++j) {
					int num = graph[curr[0]].get(j);
					if(visited[num]) continue;
					
					queue.add(new int[] {num, curr[1]+1});
					visited[num] = true;
				}
			}
		
		}
		
		return sum;
	}
}
