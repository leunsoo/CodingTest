import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int arrSize = Integer.parseInt(br.readLine());
	    StringTokenizer stk = new StringTokenizer(br.readLine());
	    int[] intArr = new int[arrSize];
	    
	    for(int i = 0; i < arrSize; ++i)
	    {
	        intArr[i] = Integer.parseInt(stk.nextToken());
	    }
	    
	    Arrays.sort(intArr);
	    
	    int targetArrSize = Integer.parseInt(br.readLine());
	    stk = new StringTokenizer(br.readLine());
	    
	    for(int i = 0; i < targetArrSize; ++i)
	    {
	        int findIdx = Arrays.binarySearch(intArr,Integer.parseInt(stk.nextToken()));
	        
	        if(findIdx >= 0) 
	            System.out.println(1);
	        else
	            System.out.println(0);
	    }   
	}
}