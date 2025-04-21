import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; ++tc) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			int[] dp = new int[N+1];
			
			StringTokenizer stk = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; ++i) {
				arr[i] = Integer.parseInt(stk.nextToken());
			}
			
			int max = 0;
			for(int i = 0; i < N; ++i) {
				dp[arr[i]] = dp[arr[i]-1]+1;
				max = Math.max(dp[arr[i]], max);
			}
			
			int answer = N-max;
			System.out.println("#"+tc+" "+answer);
		}
	}
}
