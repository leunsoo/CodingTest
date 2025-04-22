import java.io.*;
import java.util.*;

public class Main {
	static int M; 
	static int N;
	static int[][] map;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		M = Integer.parseInt(stk.nextToken());
		N = Integer.parseInt(stk.nextToken());
		
		map = new int[M][N];
		dp = new int[M][N];
		
		for(int i = 0; i < M; ++i) {
			stk = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; ++j) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		for(int i = 0; i < M; ++i) {
			Arrays.fill(dp[i], -1);
		}
		
		dp[M-1][N-1] = 1;
		
		dfs(0, 0);
		
		System.out.println(dp[0][0]);
		
	}
	
	//상하좌우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	
	private static int dfs(int r, int c) {
		if(dp[r][c] != -1) {
			return dp[r][c];
		}
		dp[r][c] = 0;
		
		for(int i = 0; i < 4; ++i) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr < 0 || nc < 0 || nr >= M || nc >= N || map[r][c] <= map[nr][nc]) continue;
			
			dp[r][c] += dfs(nr, nc);			
		}
		
		return dp[r][c];
	}	
}
