import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		int[] dp = new int[N];
		int[] dp2 = new int[N];
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(stk.nextToken());
			dp[i] = 1;
		}
		
		
		// 정방향
		for(int i = 0; i < N; ++i) {
			for(int j = i+1; j < N; ++j) {
				if(arr[i] < arr[j])	dp[j] = Math.max(dp[j], dp[i]+1);
			}
		}

		// 역방향
		for(int i = N-1; i >= 0; --i) {
			for(int j = i-1; j >= 0; --j) {
				if(arr[i] < arr[j])	dp2[j] = Math.max(dp2[j], dp2[i]+1);
			}
		}
		
		int max = 0;
		for(int i = 0; i < N; ++i) {
			int sum = dp[i] + dp2[i];
			
			if(max < sum) max = sum;
		}
		
		System.out.println(max);
	}
}
