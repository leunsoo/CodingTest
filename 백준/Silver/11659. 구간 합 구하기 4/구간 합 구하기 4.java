import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer stk = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(stk.nextToken());
    	int M = Integer.parseInt(stk.nextToken());
    	
    	int[] arr = new int[N+1];
    	
    	stk = new StringTokenizer(br.readLine());
    	int sum = 0;
    	for(int i = 1; i <= N; ++i) {
    		sum += Integer.parseInt(stk.nextToken());
    		arr[i] = sum;
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < M; ++i) {
    		stk = new StringTokenizer(br.readLine());
    		int start = Integer.parseInt(stk.nextToken());
    		int end = Integer.parseInt(stk.nextToken());
    		
    		sb.append(arr[end] - arr[start-1]).append("\n");
    	}
    	
    	System.out.println(sb);
    }
}