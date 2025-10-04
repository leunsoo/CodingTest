import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        int N = Integer.parseInt(strs[0]);
        int K = Integer.parseInt(strs[1]);
        
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        
        for(int i = 1; i <= N; ++i) {
        	dq.add(i);
        }
        
        int cnt = 1;
        
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while (!dq.isEmpty()) {
        	int people = dq.pollFirst();
        	
        	if(cnt == K) {
        		cnt = 0;
        		sb.append(people).append(", ");
        	}
        	else {
				dq.addLast(people);
			}
        	
        	cnt++;
		}
        if(sb.length() > 2) sb.replace(sb.length()-2, sb.length(), "");
        
        sb.append(">");
        System.out.println(sb);
        
    }
}