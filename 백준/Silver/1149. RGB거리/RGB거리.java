import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] houses = new int[N][3]; //RGB

		for(int i = 0; i < N; ++i) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; ++j) {
				houses[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		int[][] dp = new int[N][3];
		dp[0][0] = houses[0][0];
		dp[0][1] = houses[0][1];
		dp[0][2] = houses[0][2];
		
		for(int i = 1; i < N; ++i) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + houses[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + houses[i][1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + houses[i][2]; 
		}
		
		System.out.println(Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2])));
	}
	
}