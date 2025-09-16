import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int[][] dp = new int[15][15];
		
		for(int i = 1; i <= 14; ++i) {
			dp[0][i] = i;
		}
		
		for(int r = 1; r <= 14; ++r) { // a층
			for(int c = 1; c <= 14; ++c) { // b호
				for(int k = 1; k <= c; ++k) { // 아래 층
					dp[r][c] += dp[r-1][k];
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int tc = 0; tc < T; ++tc) {
			int k = Integer.parseInt(br.readLine()); // k층
			int n = Integer.parseInt(br.readLine()); // n호
			
			sb.append(dp[k][n]).append("\n");
		}
		System.out.println(sb);
	}
}
