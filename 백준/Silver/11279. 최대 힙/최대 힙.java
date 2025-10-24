import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	
    	PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
    	
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < N; ++i) {
    		int n = Integer.parseInt(br.readLine());
    		
    		if(n == 0) {
    			if(pq.isEmpty()) {
    				sb.append("0");
    			}
    			else {
					sb.append(pq.poll());
				}
    			
    			sb.append("\n");
    		}
    		else {
				pq.add(n);
			}
    	}
    	
    	System.out.println(sb);
	}
}