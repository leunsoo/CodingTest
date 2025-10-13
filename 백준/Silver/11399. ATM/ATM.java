import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	int[] arr = new int[N];
    	
    	StringTokenizer stk = new StringTokenizer(br.readLine());
    	for(int i = 0; i < N; ++i) {
    		arr[i] = Integer.parseInt(stk.nextToken());
    	}
    	
    	Arrays.sort(arr);
    	
    	int sum = 0;
    	
    	for(int i = 0; i < N; ++i) {
    		for(int j = 0; j <= i; ++j) {
    			sum += arr[j];
    		}
    	}
    	System.out.println(sum);
    }
}