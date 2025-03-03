import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; ++tc) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[2][N];
			
			for(int i = 0; i < 2; ++i) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; ++j) {
					arr[i][j] = Integer.parseInt(stk.nextToken());
				}
			}

			if(N == 1) {
				bw.write(Math.max(arr[0][0], arr[1][0])+"\n");
				continue;
			}
			
			int[][] dp = new int[2][N];
			
			dp[0][0] = arr[0][0];
			dp[1][0] = arr[1][0];
			dp[0][1] = dp[1][0] + arr[0][1];
			dp[1][1] = dp[0][0] + arr[1][1];
			
			for(int i = 2; i < N; ++i) {
				dp[0][i] = arr[0][i] + Math.max(dp[1][i-1], dp[1][i-2]);
				dp[1][i] = arr[1][i] + Math.max(dp[0][i-1], dp[0][i-2]);
			}
			
			bw.write(Math.max(dp[0][N-1], dp[1][N-1])+"\n");
		}
		
		bw.flush();
	}
	
}