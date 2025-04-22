import java.io.*;
import java.util.*;

public class Main {
	static int V;
	static int E;
	static int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(stk.nextToken());
		E = Integer.parseInt(stk.nextToken());
		
		int[][] arr = new int[V+1][V+1];
		
		for(int i = 0; i <= V; ++i) {
			Arrays.fill(arr[i], INF);
		}
		
		
		for(int i = 0; i < E; ++i) {
			stk = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(stk.nextToken());
			int to = Integer.parseInt(stk.nextToken());
			int cost = Integer.parseInt(stk.nextToken());
			
			arr[from][to] = cost;
		}
		
		
		for(int j = 1; j <= V; ++j) // 경 
		{
			for(int i = 1; i <= V; ++i) // 촐
			{
				for(int k = 1; k <= V; ++k) // 도 
				{
					if(arr[i][j] != INF && arr[j][k] != INF) {
						arr[i][k] = Math.min(arr[i][k], arr[i][j] + arr[j][k]);
					}
				}
			}
		}
		
		//가장 작은 사이클 찾기
		int min = INF;
		for(int i = 1; i <= V; ++i) {
			for(int j = 1; j <= V; ++j) {
				if(arr[i][j] != INF && arr[j][i] != INF) {
					min = Math.min(min, arr[i][j] + arr[j][i]);
				}
			}
		}
		
		System.out.println(min == INF ? -1 : min);
	}
	
}
