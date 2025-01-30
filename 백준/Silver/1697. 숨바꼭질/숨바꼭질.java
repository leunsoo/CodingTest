
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(stk.nextToken()); // 수빈
		int k = Integer.parseInt(stk.nextToken()); // 동생
		int max = 100000;
		boolean[] visited = new boolean[max+1];
		int d = 0;

		if (k <= n) {
			System.out.print(n - k);
			return;
		}
		if (n == 0) {
			d++;
			n++;
		}
		
		
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(n);
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			for(int i = 0; i < size; ++i)
			{
				int num = queue.poll();
				if(visited[num]) continue;
				
				visited[num] = true;
				if(num == k)
				{
					System.out.println(d);
					return;
				}
				
				if(num+1 <= max && !visited[num+1]) queue.add(num+1);
				if(num-1 > 0 && !visited[num-1]) queue.add(num-1);
				if(num*2 <= max && !visited[num*2]) queue.add(num*2);
			}
			d++;
		}
	}
}
