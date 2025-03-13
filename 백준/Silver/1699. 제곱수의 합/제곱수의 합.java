import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N+1];
		
		int n = (int)Math.sqrt(N);
		Arrays.fill(dp, Integer.MAX_VALUE-1);
		dp[0] = 0;
		
		for(int i = n; i > 0; --i) {
			for(int j = i*i; j <= N; ++j) {
				dp[j] = Math.min( dp[j-i*i]+1, dp[j] );
			}
		}
		
		System.out.println(dp[N]);
	}
}
