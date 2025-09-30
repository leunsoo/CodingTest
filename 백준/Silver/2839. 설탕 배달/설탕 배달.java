import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
		
        int[] dp = new int[5001];
        Arrays.fill(dp, 1234567890);
        dp[3] = 1;
        dp[5] = 1;
        
        for(int i = 6; i <= N; ++i) {
        	dp[i] = Math.min(dp[i-3], dp[i-5])+1;
        }
        
        System.out.println(dp[N] > 10000 ? -1 : dp[N]);
    }
}