import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static int[][] map;
	static int cheese = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);
		
		map = new int[N][M];
		
		for(int i = 0; i < N; ++i) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; ++j) {
				int num = Integer.parseInt(stk.nextToken());
				map[i][j] = num;
				
				if(num == 1) 
					cheese++;
			}
		}
		
		int cnt = 0;
		int last = 0;
		while (cheese > 0) {
			cnt++;
			last = bfs();
			cheese -= last; 
		}
		
		System.out.println(cnt);		
		System.out.println(last);
	}
	
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] visited; 
	
	//치즈 녹이기 및 치즈 카운트 
	private static int bfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { 0,0 });
		visited = new boolean[N][M];
		int cnt = 0;
		
		while (!queue.isEmpty()) {
			int[] pos = queue.poll();
			
			for(int d = 0; d < 4; ++d) {
				int nr = pos[0] + dr[d];
				int nc = pos[1] + dc[d];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				if(visited[nr][nc]) continue;
				
				if(map[nr][nc] == 1) { 
					cnt++;
					map[nr][nc] = 0;
 				}
				else {
					queue.add(new int[] {nr, nc});
				}
				
				visited[nr][nc] = true;				
			}
		}
		
		return cnt;
	}
	
}
