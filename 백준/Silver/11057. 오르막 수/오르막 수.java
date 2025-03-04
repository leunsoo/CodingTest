import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] dp = new int[N + 1][10];

		Arrays.fill(dp[1], 1);

		for (int i = 2; i <= N; ++i) {
			for (int j = 0; j < 10; ++j) {
				for (int k = j; k < 10; ++k) {
					dp[i][j] += dp[i - 1][k]%10007;
				}
			}
		}

		int answer = 0;
		for (int i = 0; i < 10; ++i) {
			answer += dp[N][i];
		}
		System.out.println(answer%10007);
	}
}
