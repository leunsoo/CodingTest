import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		int[] nums = new int[N];
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; ++i) {
			nums[i] = Integer.parseInt(stk.nextToken());
		}
		
		int[] operator = new int[4];
		
		stk = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; ++i) {
			operator[i] = Integer.parseInt(stk.nextToken());
		}
		
		dfs(1, nums[0], nums, operator);
		
		System.out.println(max);
		System.out.println(min);
		
	}
	
	private static void dfs(int cnt, int v, int[] nums, int[] operators) {
		if(cnt == N) {
			if(v > max) max = v;
			if(v < min) min = v;
			return;
		}
		
		for(int i = 0; i < 4; ++i) {
			if(operators[i] == 0) continue;
			operators[i]--;
			dfs(cnt+1, calculate(i,v,nums[cnt]), nums, operators);
			operators[i]++;
		}
	}
	
	private static int calculate(int operator,int n1, int n2) {
		switch (operator) {
		case 0:
			return n1+n2;
		case 1:
			return n1-n2;
		case 2:
			return n1*n2;
		case 3:
			return n1/n2;
		default:
			return -1;
		}
	}
}
