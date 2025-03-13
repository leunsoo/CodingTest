import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		int[][] dp = new int[N][2];
		
		for(int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		if(N < 2) {
			System.out.println(arr[0]);
			return;
		}
		
		// 0 == 점프해서 올랐다.
		// 1 == 두번째 밟았다.
		
		dp[0][0] = 0;
		dp[0][1] = arr[0];
		dp[1][0] = arr[1];
		dp[1][1] = dp[0][1] + arr[1];
		
		for(int i = 2; i < N; ++i) {
			dp[i][0] = Math.max(dp[i-2][1], dp[i-2][0]) + arr[i];
			dp[i][1] = Math.max(dp[i-1][0], dp[i-2][1]) + arr[i];
		}
		
		System.out.println(Math.max(dp[N-1][0], dp[N-1][1]));
		
	}
}
