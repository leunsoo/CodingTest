
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int arrSize = Integer.parseInt(br.readLine());
    	int[] intArr = new int[101];
    	
    	int[] aArr = new int[arrSize];
    	int[] bArr = new int[arrSize];
    	
    	StringTokenizer stk = new StringTokenizer(br.readLine());
    	for(int i = 0; i < arrSize; ++i)
    	{
    		aArr[i] = Integer.parseInt(stk.nextToken());
    	}
    	
    	stk = new StringTokenizer(br.readLine());
    	
    	for(int i = 0; i < arrSize; ++i)
    	{
    		intArr[Integer.parseInt(stk.nextToken())]++;
    	}
    	
    	Arrays.sort(aArr);
    	
    	int max = 100;
    	int answer = 0;
    	for(int i = 0; i < arrSize; ++i)
    	{
    		while (true) {
    			if(intArr[max] == 0) 
    			{
    				max--;
    				continue;
    			}
    			
    			answer += max * aArr[i];
    			intArr[max]--;
    			break;
    		}
    	}
    	
    	System.out.print(answer);
    }
}