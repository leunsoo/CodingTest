
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int count = Integer.parseInt(br.readLine());
    	int[][] intArr = new int[count][2];
    	
    	for(int i = 0; i < count; ++i)
    	{
    		StringTokenizer stk = new StringTokenizer(br.readLine());
    		intArr[i][0] =  Integer.parseInt(stk.nextToken());
    		intArr[i][1] =  Integer.parseInt(stk.nextToken());
    	}
    	
    	Arrays.sort(intArr, new Comparator<int[]>() {
    		public int compare(int[] o1, int[] o2) {
    			if(o1[1] == o2[1])  
    			{
    				return o1[0] - o2[0]; 
    			}
    			else {
					return o1[1] - o2[1]; 
				}
			}
		});
    	
    	
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < count; ++i)
    	{
    		sb.append(intArr[i][0]).append(" ").append(intArr[i][1]).append("\n");
    	}
    	
    	System.out.println(sb.toString());
    }
}
