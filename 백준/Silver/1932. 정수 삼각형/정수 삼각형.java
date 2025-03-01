import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] dp = new int[N][N];

		for (int i = 0; i < N; ++i) {
			StringTokenizer stk = new StringTokenizer(br.readLine());

			for (int j = 0; j < i + 1; ++j) {
				dp[i][j] = Integer.parseInt(stk.nextToken());
			}
		}

		for (int i = 1; i < N; ++i) {
			dp[i][0] += dp[i - 1][0];
			dp[i][i] += dp[i - 1][i - 1];

			for (int j = 1; j < i; ++j) {
				dp[i][j] += Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
			}
		}

		System.out.println(Arrays.stream(dp[N - 1]).max().getAsInt());
	}
}
