import java.io.*;
import java.util.*;

public class Main {
	static class Node implements Comparable<Node> {
		int r,c,cost;
		
		public Node(int r, int c, int cost) {
			this.r = r;
			this.c = c;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
	
	static int[][] map;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = 1;
		
		while (true) {
			N = Integer.parseInt(br.readLine());
			if(N==0) break;
			
			map = new int[N][N];
			
			for(int i = 0; i < N; ++i) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; ++j) {
					map[i][j] = Integer.parseInt(stk.nextToken());
				}
			}
			
			sb.append("Problem ").append(tc++).append(": ").append(dijkstra()).append("\n");
		}
		
		System.out.println(sb);
	}
	
	//상하좌우 
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	
	static int dijkstra() {
		int[][] dist = new int[N][N];
		
		for(int i = 0; i < N; ++i) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		dist[0][0] = map[0][0];
		pq.add(new Node(0, 0, map[0][0]));
		
		while (true) {
			Node curr = pq.poll();
			int r = curr.r;
			int c = curr.c;
			int cost = curr.cost;
			
			if(cost > dist[r][c]) continue;
			
			if( r == N-1 && c == N-1) {
				return cost;
			}
			
			for(int d = 0; d < 4; ++d) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				
				int newCost = cost + map[nr][nc];
				
				if(newCost < dist[nr][nc]) {
					dist[nr][nc] = newCost;
					pq.add(new Node(nr,nc,newCost));
				}
			}
		}
	}
}