import java.io.*;
import java.util.*;

class Edge{
	int to;
	int cost;
	
	public Edge(int to, int cost) {
		this.to = to;
		this.cost = cost;
	}
}

public class Main {
	static int[] dist; // 최고 비용 저장 
	static ArrayList<Edge>[] graph;
	static ArrayList<Edge>[] reverse; //역추적용 
	static int[] indegree;
	static int edgeCnt;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		dist = new int[N+1];
		indegree = new int[N+1];
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
			indegree[to]++;
		}
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(stk.nextToken());
		int end = Integer.parseInt(stk.nextToken());
		
		topologicalSort(start, end);
		reverse(end);
		
		System.out.println(dist[end]);
		System.out.println(edgeCnt);
	}
	
	//위상 
	static void topologicalSort(int start, int end) {
		Queue<Edge> queue = new ArrayDeque();
		queue.add(new Edge(start, 0));
		dist[start] = 0;
		
		while (!queue.isEmpty()) {
			Edge e = queue.poll();

			for (Edge edge : graph[e.to]) {
				indegree[edge.to]--;
				dist[edge.to] = Math.max(dist[edge.to], dist[e.to] + edge.cost);
				
				if(indegree[edge.to] == 0) {
					queue.add(edge);
				}
			}
		}
	}
	
	//역추적 
	static void reverse(int end) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(end);
		boolean[] visited = new boolean[N+1];
		
		while (!queue.isEmpty()) {
			int e = queue.poll();
			
			for (Edge edge : reverse[e]) {
				if(dist[edge.to] + edge.cost == dist[e]) {
					edgeCnt++;
					
					if(!visited[edge.to]) { 
						queue.add(edge.to);
						visited[edge.to] = true;
					}
				}
			}
		}
	}
}
