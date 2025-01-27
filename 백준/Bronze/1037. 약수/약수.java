
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	int min = 1000000;
    	int max = 2;
    	
    	StringTokenizer stk = new StringTokenizer(br.readLine());
    	for(int i = 0; i < n; ++i)
    	{
    		int num = Integer.parseInt(stk.nextToken());
    		if(min > num) min = num;
    		if(max < num) max = num;
    	}
    	
    	System.out.print(min*max);
    }
}
