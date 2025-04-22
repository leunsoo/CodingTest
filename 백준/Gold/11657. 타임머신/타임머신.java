import java.io.*;
import java.util.*;

class Edge {
	int from;
	int to;
	int cost;
	
	public Edge(int from, int to, int cost) {
		this.from = from;
		this.to = to;
		this.cost = cost;
	}
}

public class Main {
	static int N;
	static int M;
	static ArrayList<Edge> edges;
	static long[] dist;
	static int INF = 987654321;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		
		edges = new ArrayList<>();
		dist = new long[N+1];
		
		Arrays.fill(dist, INF);
		
		for(int i = 0; i < M; ++i) {
			stk = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(stk.nextToken());
			int to = Integer.parseInt(stk.nextToken());
			int cost = Integer.parseInt(stk.nextToken());
			
			edges.add(new Edge(from, to, cost));
		}
		
		dist[1] = 0;
		
		for(int i = 0; i < N-1; ++i) {
		    boolean updated = false;
			for (Edge edge : edges) {
				if(dist[edge.from] != INF && dist[edge.to] > dist[edge.from] + edge.cost ) {
					dist[edge.to] = dist[edge.from] + edge.cost;
		            updated = true;
				}
			}
			if (!updated) break; 
		}
		

		boolean cycle = false;
		for (Edge edge : edges) {
			if(dist[edge.from] != INF && dist[edge.to] > dist[edge.from] + edge.cost ) {
				cycle = true;
				break;
			}
		}
		
		if(cycle) {
			System.out.println(-1);
		}
		else {
			StringBuilder sb = new StringBuilder();
			for(int i = 2; i <= N; ++i) {
				sb.append(dist[i] == INF ? -1 : dist[i]).append("\n");
			}
			
			System.out.println(sb);
		}
	}

}
