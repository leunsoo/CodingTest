import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer stk = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(stk.nextToken());
    	int M = Integer.parseInt(stk.nextToken());
    	
    	HashMap<String, String> hm = new HashMap<>();
    	
    	for(int i = 0; i < N; ++i) {
    		stk = new StringTokenizer(br.readLine());
    		hm.put(stk.nextToken(), stk.nextToken());
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < M; ++i) {
    		sb.append(hm.get(br.readLine())).append("\n");
    	}
    	System.out.println(sb);
    }
}