import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][N];
		long[][] dp = new long[N][N]; // 답 범위 체크 
		
		for(int i = 0; i < N; ++i) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; ++j) {
				arr[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		dp[0][0] = 1;
		
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < N; ++j) {
				if(dp[i][j] == 0) continue; // 도달할 수 없는 곳  
				if(i == N-1 && j == N-1) continue; // 끝에 도착 
				
				int num = arr[i][j];
				
				//범위 체크 
				if(i+num < N) {
					dp[i+num][j] += dp[i][j];
				}
				
				if(j+num < N) {
					dp[i][j+num] += dp[i][j];
				}
			}
		}
		
		System.out.println(dp[N-1][N-1]);
	}
}
