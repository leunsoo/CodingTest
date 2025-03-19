import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] nums;
	static Set<Integer> set = new TreeSet<Integer>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		nums = new int[N];
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; ++i) {
			nums[i] = Integer.parseInt(stk.nextToken());
		}

		dfs(0, 0, 0);
		
		int check = 0;
		for (int num : set) {
			if(num > check) {
				System.out.println(check);
				return;
			}
			check++;
		}
		
		System.out.println(check);
	}
	
	private static void dfs(int cnt, int idx, int value) {
		set.add(value);
		
		if(cnt == N) {
			return;
		}
		
		for(int i = 0; i < N; ++i) {
			if(i < idx) continue;
			
			dfs(cnt + 1, i+1, value + nums[i]);
		}
	}
}