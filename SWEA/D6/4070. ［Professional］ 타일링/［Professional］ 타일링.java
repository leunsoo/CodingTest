import java.io.*;
import java.math.BigInteger;
import java.util.*;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        BigInteger[] dp = new BigInteger[251];
        
        dp[0] = BigInteger.ONE;
        dp[1] = BigInteger.valueOf(1);
        BigInteger two = BigInteger.valueOf(2);
        
        for(int i = 2; i <= 250; ++i) {
        	dp[i] = dp[i-1].add(dp[i-2].multiply(two));
        }
        
        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc <= T; ++tc) {
            sb.append("#").append(tc).append(" ").append(dp[Integer.parseInt(br.readLine())]).append("\n");
        }   
         
        System.out.println(sb.toString());
    }
}