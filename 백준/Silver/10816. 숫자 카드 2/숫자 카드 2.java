
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int numCnt = Integer.parseInt(br.readLine());
    	
    	HashMap<Integer, Integer> hash = new HashMap<>();
    	
    	StringTokenizer stk = new StringTokenizer(br.readLine());
    	for(int i = 0; i < numCnt; ++i)
    	{
    		int num = Integer.parseInt(stk.nextToken());
    		hash.put(num, hash.getOrDefault(num,0)+1);
    	}

    	int compNumCnt = Integer.parseInt(br.readLine());
    	stk = new StringTokenizer(br.readLine());
    	
    	StringBuilder sb = new StringBuilder();
    	
    	for(int i = 0; i < compNumCnt; ++i)
    	{
    		sb.append(hash.getOrDefault(Integer.parseInt(stk.nextToken()), 0)).append(" ");
    	}
    	
    	System.out.print(sb);
    }
}
