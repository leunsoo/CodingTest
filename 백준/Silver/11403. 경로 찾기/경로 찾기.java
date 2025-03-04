import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer>[] graph;
	static int[][] answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[N];
		answer = new int[N][N];
		
		for(int i = 0; i < N; ++i) {
			graph[i] = new ArrayList<Integer>();
			
			StringTokenizer stk = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; ++j) {
				int num = Integer.parseInt(stk.nextToken());
				
				if(num == 1) {
					graph[i].add(j);
				}
			}
		}
		
		for(int i = 0; i < N; ++i) {
			bfs(i, N);
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < N; ++j) {
				sb.append(answer[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
	
	private static void bfs(int index, int N) {
		boolean[] visited = new boolean[N];
		
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(index);
		
		while (!queue.isEmpty()) {
			int curr = queue.poll();
			
			for(int i = 0; i < graph[curr].size(); ++i) {
				int num = graph[curr].get(i);
				if(visited[num]) continue;
				
				queue.add(num);
				visited[num] = true;
				answer[index][num] = 1;
			}
		}
	}
}
