import java.io.*;

public class Main {
    private	static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < t; ++i)
        {
        	count = 0;
            int num = Integer.parseInt(br.readLine()); 
        	recusive(num);
        	System.out.println(count);
        }
    }
    
    
    private static void recusive(int num)
    {
    	if(num == 0)
    	{
    		count++;
    		return;
    	}
    	
    	recusive(num-1);
    	
    	if(num - 2 >= 0)
    		recusive(num-2);
    	
    	if(num - 3 >= 0)
    		recusive(num-3);
    }
}
