import java.io.*;
import java.util.*;

class Number {
	long num;
	int cnt;
	
	public Number(long num, int cnt) {
		this.num = num;
		this.cnt = cnt;
	}
}

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(stk.nextToken());
        int target = Integer.parseInt(stk.nextToken());
        
        System.out.println(bfs(start, target));
    }
    
    static int bfs(int start, int target) {
    	Queue<Number> queue = new ArrayDeque<>();
    	queue.add(new Number(start, 0));
    	
    	while (!queue.isEmpty()) {
			Number n = queue.poll();

    		if(n.num == target) {
    			return n.cnt+1;
    		}
    		if(n.num > target/2)
    			continue;
    		
    		queue.add(new Number(n.num*10+1, n.cnt+1));
    		queue.add(new Number(n.num*2, n.cnt+1));
		}
    	
    	
    	return -1;
    }
}
