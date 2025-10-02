import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        
        for(int i=  0; i < K; ++i) {
        	int n = Integer.parseInt(br.readLine());
        	
        	if(n == 0)  {
        		dq.pollLast();
        	}
        	else {
				dq.addLast(n);
			}
        }
        
        int sum = 0;
        for(int i : dq) {
        	sum += i;
        }
        System.out.println(sum);
    }
}