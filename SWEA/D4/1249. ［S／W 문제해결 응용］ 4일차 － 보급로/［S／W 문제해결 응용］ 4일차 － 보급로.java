import java.io.*;
import java.util.*;

class State implements Comparable<State> {
	int r;
	int c;
	int cost;
	
	public State(int r, int c, int cost) {
		this.r = r;
		this.c = c;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(State o) {
		return this.cost - o.cost;
	}
}

public class Solution {
	static int[][] map;
	static int[][] dist;
	static int min;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= T; ++ tc)
		{
			sb.append("#").append(tc).append(" "); 
			
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			min = Integer.MAX_VALUE;
			dist = new int[N][N];
			
			for(int i = 0; i < N; ++i) {
				String str = br.readLine();
				for(int j = 0; j < N; ++j) {
					map[i][j] = str.charAt(j) - '0';
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
			
			dijkstra();
			
			sb.append(min).append("\n");
			
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	//상하좌우 
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	
	private static void dijkstra() {
		PriorityQueue<State> queue = new PriorityQueue<>();
		queue.add(new State(0, 0, 0));
		dist[0][0] = 0;
		
		while (!queue.isEmpty()) {
			State curr = queue.poll();
			
			for(int d = 0; d < 4; ++d) {
				int nr = curr.r + dr[d];
				int nc = curr.c + dc[d];
				
				if(outBound(nr, nc)) continue;
				
				int cost = curr.cost + map[nr][nc];
				if(dist[nr][nc] <= cost) continue;
				
				dist[nr][nc] = cost;
				queue.add(new State(nr, nc, cost));
			}
		}
		
		min = dist[N-1][N-1];
	}
	
	//맵 밖으로 나갈 시 true
	private static boolean outBound(int r, int c) {
		return ( r < 0 || c < 0 || r >= N || c >= N);
	}
}
