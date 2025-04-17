import java.util.*;
import java.io.*;

public class Solution {
	static int N;
	static int[][] arr;
	static boolean[] visited;
	static int max;
	static int startR;
	static int startC;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= T; ++tc) {
			sb.append("#").append(tc).append(" ");
			
			N = Integer.parseInt(br.readLine());
			
			visited = new boolean[101];
			arr = new int[N][N];
			max = -1;
			
			for(int i = 0; i < N; ++i) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; ++j) {
					arr[i][j] = Integer.parseInt(stk.nextToken());
				}
			}
			
			for(int i = 0; i < N; ++i) {
				for(int j = 0; j < N; ++j) {
					startR = i;
					startC = j;
					dfs(i, j, 0, 0);
				}
			}
			
			sb.append(max).append("\n");
		}
		
		System.out.println(sb);
	}
	
	private static int[] dr = { -1, -1, 1, 1 };
	private static int[] dc = { -1, 1, 1, -1 };
	
	private static void dfs(int r, int c, int dir, int cnt) {
		if(cnt >= 4 && r == startR && c == startC) {
			max = Math.max(max, cnt);
			return;
		}
		
		for(int i = dir; i < 4; ++i) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(isOut(nr, nc) || visited[arr[nr][nc]]) continue;
			
			visited[arr[nr][nc]] = true;
			dfs(nr, nc, i, cnt+1);
			visited[arr[nr][nc]] = false;
		}
	}
	
	private static boolean isOut(int r, int c) {
		if(r < 0 || c < 0 || r >= N || c >= N) return true;
		return false;
	}
}
