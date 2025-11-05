import java.io.*;
import java.util.*;


public class Main {
	static final int MAX = 100_000;
	static boolean[] visited;
	static int N;
	static int K;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		K = Integer.parseInt(stk.nextToken());
		
		visited = new boolean[MAX+1];
		
		int[] res = bfs();
		System.out.println(res[0]);
		System.out.println(res[1]);	
	}
	
	static int[] bfs() {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(N);
		
		int cnt = 0;
		int fastest = 0;
		boolean flag = false;
		
		while (true) {
			int size = queue.size();
			
			for(int i = 0; i < size; ++i) {
				int curr = queue.poll();
				
				if(curr == K) {
					flag = true;
					cnt++;
				}
				
				if(curr < 0 || curr > MAX) continue;
				visited[curr] = true;
				
				int down = curr-1;
				int up = curr+1;
				int jump = curr*2;
				
				if(down >= 0 && !visited[down]) {
					queue.add(down);
				}
				
				if(up <= MAX && !visited[up]) {
					queue.add(up);
				}
				
				if(jump <= MAX && !visited[jump]) {
					queue.add(jump);
				}
			}
			
			if(flag) {
				return new int[] { fastest, cnt};
			}
			
			fastest++;
		}
	}
}