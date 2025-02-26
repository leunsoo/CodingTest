import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N+1];
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; ++i) {
			dp[i] = Integer.parseInt(stk.nextToken());
			for(int j = 0; j <= i/2; ++j) {
				dp[i] = Math.min(dp[i], dp[i-j]+dp[j]);
			}
		}
		
		System.out.println(dp[N]);
	}
}
