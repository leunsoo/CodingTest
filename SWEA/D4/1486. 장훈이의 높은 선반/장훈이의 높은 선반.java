import java.io.*;
import java.util.*;
 
public class Solution {
	static int min;
	static int N;
	static int B;
	static int[] arr;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc <= T; ++tc) {
            sb.append("#").append(tc).append(" ");
            
            StringTokenizer stk = new StringTokenizer(br.readLine());
            N = Integer.parseInt(stk.nextToken());
            B = Integer.parseInt(stk.nextToken());
            
            arr = new int[N];
            min = Integer.MAX_VALUE;
            
            stk = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; ++i) {
            	arr[i] = Integer.parseInt(stk.nextToken());
            }
            
            dfs(0, 0);
            sb.append(min-B).append("\n");
        }   
         
        System.out.println(sb.toString());
    }
    
    private static void dfs(int sum, int idx) {
    	if(sum >= min) return;
    	
    	if(sum >= B) {
    		min = Math.min(sum, min);
    		return;
    	}
    	
    	for(int i = idx; i < N; ++i) {
    		dfs(sum + arr[i], i+1);
    	}
    }
}