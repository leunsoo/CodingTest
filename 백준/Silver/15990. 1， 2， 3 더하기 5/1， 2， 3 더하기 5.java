import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[][] dp = new int[100001][4];

		dp[1][1] = 1;
		dp[1][2] = 0;
		dp[1][3] = 0;

		dp[2][1] = 0;
		dp[2][2] = 1;
		dp[2][3] = 0;

		dp[3][1] = 1;
		dp[3][2] = 1;
		dp[3][3] = 1;

		for (int i = 4; i <= 100000; ++i) {
			dp[i][1]= (dp[i-1][2]+dp[i-1][3])%1000000009;
			dp[i][2]= (dp[i-2][1]+dp[i-2][3])%1000000009;
			dp[i][3]= (dp[i-3][1]+dp[i-3][2])%1000000009;
		}
		
		for(int t = 0; t < N; ++t) 
		{
			int target = sc.nextInt();
			long answer = dp[target][1];
			answer += dp[target][2];
			answer += dp[target][3];
			System.out.println(answer%1000000009);
		}
	}

}
