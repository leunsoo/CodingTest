import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N]; // 포도주 저장 
		
		for(int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int[][] dp = new int[N][3];
		
		if(N == 1) {
			System.out.println(arr[0]);
			return;
		}
		
		dp[0][0] = 0;
		dp[0][1] = arr[0];
		dp[0][2] = 0;
		
		dp[1][0] = 0;
		dp[1][1] = arr[1];
		dp[1][2] = dp[0][1] + arr[1];
		
		for(int i = 2; i < N; ++i) {
			dp[i][0] = Math.max(dp[i-1][2],Math.max(dp[i-1][1], Math.max(dp[i-2][1], dp[i-2][2]))); 
			dp[i][1] = arr[i] + Math.max(dp[i-1][0], Math.max(dp[i-2][1], dp[i-2][2]));
			dp[i][2] = arr[i] + dp[i-1][1];
		}
		
		System.out.println(Math.max(dp[N-1][0], Math.max(dp[N-1][1], dp[N-1][2])));
	}
}
