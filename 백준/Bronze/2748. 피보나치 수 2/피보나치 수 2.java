import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		long[] dp = new long[num+1];
		
		if(num == 0) {
			System.out.println(0);
			return;
		}
		
		dp[0] = 0;
		dp[1] = 1;
		
		for(int i = 2; i <= num; ++i) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		System.out.println(dp[num]);
	}
}
