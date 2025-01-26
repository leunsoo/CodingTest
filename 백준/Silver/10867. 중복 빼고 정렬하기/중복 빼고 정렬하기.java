
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int arrSize = Integer.parseInt(br.readLine());
    	int[] intArr = new int[arrSize];
    	
    	StringTokenizer stk = new StringTokenizer(br.readLine());
    	for(int i = 0; i < arrSize; ++i)
    	{
    		intArr[i] = Integer.parseInt(stk.nextToken());
    	}
    	
    	Arrays.sort(intArr);
    	
    	StringBuilder sb = new StringBuilder();
    	
    	sb.append(intArr[0]).append(" ");
    	for(int i = 1; i < arrSize; ++i)
    	{
    		if(intArr[i] == intArr[i-1]) continue;
    		
    		sb.append(intArr[i]).append(" ");
    	}
    	
    	System.out.print(sb);
    }
}
