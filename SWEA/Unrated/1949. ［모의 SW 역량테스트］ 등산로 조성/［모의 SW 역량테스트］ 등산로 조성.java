import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int K;
	static int[][] map;
	static boolean[][] visited;
	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= T; ++tc) {
			sb.append("#").append(tc).append(" ");
			
			StringTokenizer stk = new StringTokenizer(br.readLine());
			N = Integer.parseInt(stk.nextToken());
			K = Integer.parseInt(stk.nextToken());
			map = new int[N][N];
			visited = new boolean[N][N];
			max = 0;
			
			ArrayList<int[]> highest = new ArrayList<>();
			int maxHeight = 0;
			
			for(int i = 0; i < N; ++i) {
				stk = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; ++j) {
					int height = Integer.parseInt(stk.nextToken());
					
					map[i][j] = height;
					
					if(height > maxHeight) {
						maxHeight = height;
						highest.clear();
						highest.add(new int[] {i,j});
					}
					else if(height == maxHeight) {
						highest.add(new int[] {i,j});
					}
				}
			}
			
			
			for (int[] pos : highest) {
				visited[pos[0]][pos[1]] = true;
				dfs(pos[0], pos[1], 0, 1);
				visited[pos[0]][pos[1]] = false;
			}
			
			sb.append(max).append("\n");
		}
		
		System.out.println(sb);
	}
	
	//상하좌우 
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	
	static void dfs(int r, int c, int destroy, int length) {
		max = Math.max(length, max);
		
		for(int d = 0; d < 4; ++d) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc]) 
				continue;
			
			if(map[nr][nc] >= map[r][c] && map[nr][nc] - map[r][c] < K && destroy == 0) {
				visited[nr][nc] = true;
				int tmp = map[nr][nc];
				map[nr][nc] = map[r][c]-1;
				dfs(nr, nc, 1, length+1);
				map[nr][nc] = tmp;
				visited[nr][nc] = false;
			}
			else if(map[nr][nc] < map[r][c]) {
				visited[nr][nc] = true;
				dfs(nr, nc, destroy, length+1);
				visited[nr][nc] = false;
			}
		}
		
	}
}