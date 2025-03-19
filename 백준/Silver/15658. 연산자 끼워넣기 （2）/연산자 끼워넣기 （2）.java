import java.io.*;
import java.util.*;

public class Main {
	static int[] opers;
	static int[] nums;
	
	static int N;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		opers = new int[4];
		nums = new int[N];
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; ++i) {
			nums[i] = Integer.parseInt(stk.nextToken());
		}
		
		stk = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; ++i) {
			int num = Integer.parseInt(stk.nextToken());
			if(num >= N) num = N-1;
			
			opers[i] = num;
		}
		
		dfs(0, nums[0]);
		
		System.out.println(max);
		System.out.println(min);
	} 
	
	private static void dfs(int cnt, int value) {
		if(cnt == N-1) {
			if(value > max) max = value;
			if(value < min) min = value;
			return;
		}
		
		for(int i = 0; i < 4; ++i) {
			if(opers[i] == 0) continue;
			
			opers[i]--;
			dfs(cnt+1, oper(i, value, nums[cnt+1]));
			opers[i]++;
		}
	}
	
	// +, -, *, /
	private static int oper(int op, int num1, int num2) {
		switch (op) {
			case 0:
				return num1 + num2;
			case 1:
				return num1 - num2;
			case 2:
				return num1 * num2;
			case 3:
				return num1 / num2;
		}
		
		return 1;
	}
}
