import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		int T = Integer.parseInt(strs[0]);
		int W = Integer.parseInt(strs[1]);
		
		int[] arr = new int[T+1];
		int[][] dp = new int[T+1][W+1];
		
		for(int i = 1; i <= T; ++i) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i = 1; i <= T; ++i) {
			dp[i][0] = dp[i-1][0];
			if(arr[i] == 1) dp[i][0]++;
			for(int w = 1; w <= W; ++w) {
				dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-1]);
				
				if(w%2 + 1 == arr[i]) {
					dp[i][w] += 1;
				}
			}
		}
		
		int max = 0;
		for(int i = 0; i <= W; ++i) {
			if(max < dp[T][i]) max = dp[T][i];
		}
		
		System.out.println(max);
	}
}
