import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[31];
		dp[0] = 1;
		
		for(int i = 2; i <= N; ++i ) {
			dp[i] = dp[i-2]*3;
			for(int j = 4; j <= i; j += 2 ) {
				dp[i] += dp[i-j]*2;
			}
		}
		
		System.out.println(dp[N]);
	}
}
