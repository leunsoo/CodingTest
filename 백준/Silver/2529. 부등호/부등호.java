import java.io.*;
import java.util.*;

public class Main {
	static String[] oper;
	static int N;
	static int[] temp;
	static boolean[] visited;
	
	static long max = Long.MIN_VALUE;
	static long min = Long.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		oper = new String[N];
		temp = new int[10];
		visited = new boolean[10];
		
		for(int i = 0; i < N; ++i) {
			oper[i] = stk.nextToken();
		}
		
		for(int i = 0; i <= 9; ++i) {
			visited[i] = true;
			temp[0] = i;
			dfs(0);
			visited[i] = false;
		}
		
		
		String maxStr = Long.toString(max);
		String minStr = Long.toString(min);
		
		//앞에 0 붙여주기
		if(maxStr.length() != minStr.length()) minStr = "0" + minStr;
		
		System.out.println(maxStr);
		System.out.println(minStr);
	}
	
	
	static void dfs(int cnt) {
		if(cnt == N) {
			//부등호 체크
			long num = 0;
			for(int i = 0; i < N; ++i) {
				if(!isCorrect(oper[i], temp[i], temp[i+1])) 
					return;
				
				num = num*10 + temp[i];
			}
			
			num = num*10 + temp[N];
			
			if(max < num) max = num;
			if(min > num) min = num;
			return;
		}
		
		for(int i = 0; i <= 9; ++i) {
			if(visited[i]) continue;
			
			temp[cnt+1] = i;
			visited[i] = true;
			dfs(cnt+1);
			visited[i] = false;
		}
	}
	
	static boolean isCorrect(String str, int left, int right) {
		if(str.equals(">"))
		{
			return left > right;
		}
		else {
			return left < right;
		}
	}
}
