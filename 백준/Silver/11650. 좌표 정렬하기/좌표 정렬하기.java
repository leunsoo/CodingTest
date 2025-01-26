
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int count = Integer.parseInt(br.readLine());
    	int[][] intArr = new int[count][];
    	
    	for(int i = 0; i < count; ++i)
    	{
    		StringTokenizer stk = new StringTokenizer(br.readLine());
    		int x =  Integer.parseInt(stk.nextToken());
    		int y =  Integer.parseInt(stk.nextToken());
    		
    		intArr[i] = new int[] { x, y };
    	}
    	
    	Arrays.sort(intArr, new Comparator<int[]>() {
    		public int compare(int[] o1, int[] o2) {
    			if(o1[0] == o2[0]) //x좌표가 같다면  
    			{
    				return o1[1] - o2[1]; //y좌표 오름차순 
    			}
    			else {
					return o1[0] - o2[0]; //x 좌표 오름차순 
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
