import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int[][] map;
	static boolean[] visited;
	
	static int answer = 0;
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		visited = new boolean[N];
		answer = Integer.MAX_VALUE;
		for(int i = 0; i < N; ++i)
		{
			StringTokenizer stk = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; ++j)
			{
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		dfs(0, 0);
		
		System.out.println(answer);
	}
	
	private static void dfs(int cnt, int idx) {
		if(cnt == N/2) {
			int aSum = 0;
			int bSum = 0;
			for(int i = 0; i < N; ++i) 
			{
				for(int j = 0; j < N; ++j)
				{
					if(visited[i] && visited[j])
					{
						aSum += map[i][j];
					}
					if(!visited[i] && !visited[j])
					{
						bSum += map[i][j];
					}
				}
			}
			
			int differ = Math.abs(aSum-bSum);
			if(answer > differ) answer = differ;
			
			return;
		}
		
		for(int i = 0; i < N; ++i) {
			if(i < idx ) continue;
			
			visited[i] = true;
			dfs(cnt+1, i+1);
			visited[i] = false;
		}
	}
}
