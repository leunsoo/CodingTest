import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        
        for(int i = 1; i <= N; ++i) {
        	dq.addLast(i);
        }
        
        int last = 1;
        while (true) {
			last = dq.pollFirst();
			
			if(dq.isEmpty()) {
				System.out.println(last);
				return;
			}
			
			int sec = dq.pollFirst();
			dq.addLast(sec);
		}
    }
}