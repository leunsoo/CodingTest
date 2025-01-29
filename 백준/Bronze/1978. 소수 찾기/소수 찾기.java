
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	int[] arr = new int[n];
    	
    	StringTokenizer stk = new StringTokenizer(br.readLine());
    	for(int i = 0; i < n; ++i)
    	{
    		arr[i] = Integer.parseInt(stk.nextToken());
    	}
    	
    	int answer = 0;
    	for(int i = 0; i < n; ++i)
    	{
    		if(arr[i] < 2) continue;
    		
    		boolean isPrime = true;
    		for(int j = 2; j < arr[i]; ++j)
    		{
    			if(arr[i]%j == 0)
    			{
    				isPrime=false;
    				break;
    			}
    		}
    		
    		if(isPrime) answer++;
    	}
    	
    	System.out.print(answer);
    }
}
