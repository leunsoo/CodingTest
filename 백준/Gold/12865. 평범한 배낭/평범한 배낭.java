import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int K = Integer.parseInt(stk.nextToken());
				
		int[] dp = new int[K+1];
		
		for(int i = 1; i <= N; ++i) {
			stk = new StringTokenizer(br.readLine());
			
			int weight = Integer.parseInt(stk.nextToken());
			int value = Integer.parseInt(stk.nextToken());
			
			for(int w = K; w >= weight; --w) {
				dp[w] = Math.max(dp[w-weight]+value, dp[w]);
			}
		}
		
		System.out.println(dp[K]);
		
	}
}
