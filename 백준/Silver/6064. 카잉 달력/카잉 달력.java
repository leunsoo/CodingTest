import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; ++i) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			int M = Integer.parseInt(stk.nextToken());
			int N = Integer.parseInt(stk.nextToken());
			int x = Integer.parseInt(stk.nextToken());
			int y = Integer.parseInt(stk.nextToken());
			
			bw.write(dfs(M, N, x, y) + "\n");
		}
		
		bw.flush();
	}
	
	private static int dfs(int M, int N, int x, int y) {
		if(x == y) return x;
		if(x > M*N || y > M*N) return -1;
		
		if( x > y )
			return dfs(M, N, x, y+N);
		else 
			return dfs(M, N, x+M, y);
	}
}



