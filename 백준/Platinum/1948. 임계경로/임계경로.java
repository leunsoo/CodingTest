import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
	int to;
	int cost;
	
	public Edge(int to, int cost) {
		this.to = to;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Edge o) { //최고비용순 
		return o.cost - this.cost;
	}
}

public class Main {
	static int[] dist; // 최고 비용 저장 
	static ArrayList<Edge>[] graph;
	static ArrayList<Edge>[] reverse; //역추적용 
	static int edgeCnt;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		dist = new int[N+1];
		graph = new ArrayList[N+1];
		reverse = new ArrayList[N+1];
		edgeCnt = 0;
		
		for(int i = 0; i <= N; ++i) graph[i] = new ArrayList<Edge>();
		for(int i = 0; i <= N; ++i) reverse[i] = new ArrayList<Edge>();
		
		Arrays.fill(dist, Integer.MIN_VALUE);
		
		for(int i = 0; i < M; ++i) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(stk.nextToken());
			int to = Integer.parseInt(stk.nextToken());
			int cost = Integer.parseInt(stk.nextToken());
			
			graph[start].add(new Edge(to, cost));
			reverse[to].add(new Edge(start, cost));
		}
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(stk.nextToken());
		int end = Integer.parseInt(stk.nextToken());
		
		dijkstra(start, end);
		reverse(end);
		
		System.out.println(dist[end]);
		System.out.println(edgeCnt);
	}
	
	//다익
	static void dijkstra(int start, int end) {
		Queue<Edge> pq = new ArrayDeque<Edge>();
		pq.add(new Edge(start, 0));
		dist[start] = 0;
		
		while (!pq.isEmpty()) {
			Edge e = pq.poll();
			
			if(e.cost < dist[e.to]) continue;
			
			for (Edge edge : graph[e.to]) {
				int newCost = e.cost + edge.cost;
				
				if(newCost > dist[edge.to]) {
					dist[edge.to] = newCost;
					pq.add(new Edge(edge.to, newCost));
				}
			}
		}
	}
	
	//역추적 
	static void reverse(int end) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(end);
		boolean[][] visited = new boolean[N+1][N+1];
		
		while (!queue.isEmpty()) {
			int e = queue.poll();
			
			for (Edge edge : reverse[e]) {
				if(dist[edge.to] + edge.cost == dist[e]) {
					if(!visited[e][edge.to]) { 
						edgeCnt++;
						queue.add(edge.to);
						visited[e][edge.to] = true;
					}
				}
			}
		}
	}
}


