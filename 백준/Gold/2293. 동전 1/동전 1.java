import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int k = Integer.parseInt(str[1]);
		
		int[] arr = new int[n];
		int[] dp = new int[k+1];
		
		for(int i = 0; i < n; ++i) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dp[0] = 1;
		
		for(int i = 0; i < n; ++i) { 
			for(int j = arr[i]; j <= k ; j++) {
				dp[j] += dp[j-arr[i]];
			}
		}
		
		System.out.println(dp[k]);
	}
}
