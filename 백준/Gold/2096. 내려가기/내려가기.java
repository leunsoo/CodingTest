import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[][] minDP = new int[N][3];
        int[][] maxDP = new int[N][3]; 
        
        int[][] arr = new int[N][3];
        for(int i = 0; i < N; ++i) {
        	StringTokenizer stk = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(stk.nextToken());
        	int b = Integer.parseInt(stk.nextToken());
        	int c = Integer.parseInt(stk.nextToken());
        	
        	arr[i][0] = a;
        	arr[i][1] = b;
        	arr[i][2] = c;
        }
        
        maxDP[0][0] = minDP[0][0] = arr[0][0];
        maxDP[0][1] = minDP[0][1] = arr[0][1];
        maxDP[0][2] = minDP[0][2] = arr[0][2];
        
        for(int i = 1; i < N; ++i) {
        	maxDP[i][0] = Math.max(maxDP[i-1][0], maxDP[i-1][1]) + arr[i][0];
        	maxDP[i][1] = Math.max(maxDP[i-1][0], Math.max(maxDP[i-1][1], maxDP[i-1][2])) + arr[i][1];
        	maxDP[i][2] = Math.max(maxDP[i-1][1], maxDP[i-1][2]) + arr[i][2];
        	
        	minDP[i][0] = Math.min(minDP[i-1][0], minDP[i-1][1]) + arr[i][0];
        	minDP[i][1] = Math.min(minDP[i-1][0], Math.min(minDP[i-1][1], minDP[i-1][2])) + arr[i][1];
        	minDP[i][2] = Math.min(minDP[i-1][1], minDP[i-1][2]) + arr[i][2];
        }
        
        int max = Math.max(maxDP[N-1][0], Math.max(maxDP[N-1][1], maxDP[N-1][2]));
        int min = Math.min(minDP[N-1][0], Math.min(minDP[N-1][1], minDP[N-1][2]));
        System.out.println(max + " " + min);
    }
    
}
