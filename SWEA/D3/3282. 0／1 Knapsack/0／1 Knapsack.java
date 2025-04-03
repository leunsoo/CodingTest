import java.io.*;
import java.util.*;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc <= T; ++tc) {
            sb.append("#").append(tc).append(" ");
            
            StringTokenizer stk= new StringTokenizer(br.readLine());
            int N = Integer.parseInt(stk.nextToken()); // 물건 개수
            int K = Integer.parseInt(stk.nextToken()); // 가방 부피
            
            int[] dp = new int[K+1];
            
            for(int i = 0; i < N; ++i) {
            	stk = new StringTokenizer(br.readLine());
            	int V = Integer.parseInt(stk.nextToken()); // 부피
            	int C = Integer.parseInt(stk.nextToken()); // 가치
            	
            	for(int j = K; j >= V; --j) {
            		dp[j] = Math.max(dp[j], dp[j-V]+C);
            	}
            }
             
            sb.append(dp[K]).append("\n");
        }   
         
        System.out.println(sb.toString());
    }
}