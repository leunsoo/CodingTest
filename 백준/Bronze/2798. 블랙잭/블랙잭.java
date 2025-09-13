import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	static int N;
	static int M;
	static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		arr = new int[N];
		ans = 0;
		
		stk = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(stk.nextToken());
		}
		
		dfs(0, 0, 0);
		
		System.out.println(ans);
	}
	
	static void dfs(int cnt, int idx, int sum) {
		if(cnt == 3) {
			if(sum > M) return;
			
			ans = Math.max(ans, sum);
			return;
		}
		
		for(int i = idx; i < N; ++i) {
			dfs(cnt+1, i+1, sum + arr[i]);
		}
	}
}