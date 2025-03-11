
import java.io.*;
import java.util.*;


//최고비용 구하기 
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		int N = Integer.parseInt(strs[0]);
		int K = Integer.parseInt(strs[1]);
		
		int arr[] = new int[N];
		int dp[] = new int[K+1];
		
		for(int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		
		for(int i = 0; i < N; ++i) {
			for(int j = arr[i]; j <= K; j ++) {	
		        if (dp[j - arr[i]] != Integer.MAX_VALUE) {
		            dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
		        }
			}
		}
		
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < K/2; ++i) {
			if(dp[i] == Integer.MAX_VALUE || dp[K-i] == Integer.MAX_VALUE) continue;
			
			int sum = dp[i] + dp[K-i];
			
			if(sum < min) min = sum;
		}
		
		
		if(min == Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else {
			System.out.println(min);
		}
	}
}
