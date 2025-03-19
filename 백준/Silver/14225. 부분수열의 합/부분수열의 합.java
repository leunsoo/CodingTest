import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] nums;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		nums = new int[N];
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; ++i) {
			nums[i] = Integer.parseInt(stk.nextToken());
		}

		visited = new boolean[2000000];
		
		dfs(0, 0, 0);
		
		for(int i = 1; i <= visited.length; ++i) {
			if(visited[i] == false) {
				System.out.println(i);
				return;
			}
		}
	}
	
	private static void dfs(int cnt, int idx, int value) {
		visited[value] = true;;
		
		if(cnt == N) {
			return;
		}
		
		for(int i = 0; i < N; ++i) {
			if(i < idx) continue;
			
			dfs(cnt + 1, i+1, value + nums[i]);
		}
	}
}