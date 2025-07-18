import java.io.*;
import java.util.*;

public class Main {
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < tc; ++i) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(stk.nextToken());
			int N = Integer.parseInt(stk.nextToken());
			int K = Integer.parseInt(stk.nextToken());
				
			arr = new int[N][M];
			
			for(int k = 0; k < K; ++k) {
				stk = new StringTokenizer(br.readLine());
				
				int c = Integer.parseInt(stk.nextToken());
				int r = Integer.parseInt(stk.nextToken());
				
				arr[r][c] = 1;
			}
			
			int cnt = 0;
			for(int c = 0; c < M; ++c) {
				for(int r = 0; r < N; ++r) {
					if(arr[r][c] == 1) {
						dfs(r, c, M, N);
						cnt++;
					}
				}
			}
			sb.append(cnt).append("\n");
		}
		
		System.out.println(sb);
	}
	
	//상하좌우 
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	
	private static void dfs(int r, int c, int M, int N) {
		for(int d = 0; d < 4; ++d) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
			if(arr[nr][nc] == 0) continue;
			
			arr[nr][nc] = 0;
			dfs(nr, nc, M, N);
		}
	}
}