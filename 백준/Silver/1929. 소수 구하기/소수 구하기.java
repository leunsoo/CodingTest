import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer stk = new StringTokenizer(br.readLine());
    	
    	int min = Integer.parseInt(stk.nextToken());
    	int max = Integer.parseInt(stk.nextToken())+1;
    	
    	boolean[] primes = new boolean[max];
    	
    	for(int i = 2; i < max; ++i)
    	{
    		primes[i] = true;
    	}
    	
    	for(int i = 2; i*i < max; ++i)
    	{
    		if(primes[i])
    		{
    			for(int j = 2; i*j < max; ++j)
    			{
    				primes[i*j] = false;
    			}
    		}
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	for(int i = min; i < max; ++i)
    	{
    		if(primes[i])
    		{
        		sb.append(i).append("\n");
    		}
    	}
    	System.out.println(sb);
    }
}
