import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[] nums;
	static int max;
	static int pick;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String[] str = br.readLine().split(" ");
    	max = Integer.parseInt(str[0]);
    	pick = Integer.parseInt(str[1]);
    	nums = new int[pick];
    	rrrrrrrrrrecursive(0,0);
    	bw.flush();
    	bw.close();
    }
    
    private static void rrrrrrrrrrecursive(int num, int num2) throws IOException
    {
    	if(num == pick) {
    		for (int i : nums) 
    		{
				bw.write(i+" ");
			}
    		bw.write("\n");
    		return;
    	}
    	
    	for(int i = 1; i <= max; ++i)
    	{
    		if(num2 >= i ) continue;
    		
    		nums[num] = i;
    		rrrrrrrrrrecursive(num+1, i);
    	}
    }
}