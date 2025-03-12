import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		
		int[][] dp = new int[N+1][M+1];
		
		for(int i = 1; i <= N; ++i) {
			stk = new StringTokenizer(br.readLine());
			for(int j = 1; j <= M; ++j) {
				dp[i][j] = Integer.parseInt(stk.nextToken());
				dp[i][j] += Math.max(dp[i][j-1], Math.max(dp[i-1][j], dp[i-1][j-1]));
			}
		}
		
		System.out.println(dp[N][M]);
	}
}