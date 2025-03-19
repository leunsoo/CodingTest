import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] origin;
	static int[] temp;
	static int max = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		origin = new int[N];
		temp = new int[N];
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; ++i) {
			int num = Integer.parseInt(stk.nextToken());
			origin[i] = num;
			temp[i] = num;
		}
		
		dfs(0, 0);
		System.out.println(max);
	}
	
	private static void dfs(int cnt, int value) {
		if(cnt == N-2) {
			if(max < value) max = value;
			return;
		}
		
		for(int i = 1; i < N-1; ++i) {
			if(temp[i] == 0) continue;
			
			temp[i] = 0;
			
			int left = i-1;
			int right = i+1;
			
			while (temp[left] == 0) 
				left--;
			
			while (temp[right] == 0)
				right++;
			
			dfs(cnt+1, value+temp[left]*temp[right]);
			
			temp[i] = origin[i];
		}
	}
}
