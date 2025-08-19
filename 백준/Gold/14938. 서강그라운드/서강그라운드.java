import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int to;
		int cost;
		
		public Node(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}
	
	static ArrayList<Node>[] graph;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(stk.nextToken()); // 지역의 개수 
		int m = Integer.parseInt(stk.nextToken()); // 수색의 범위
		int k = Integer.parseInt(stk.nextToken()); // 길의 개수
		
		arr = new int[n+1];
		graph = new ArrayList[n+1];
		
		stk = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; ++i) {
			arr[i] = Integer.parseInt(stk.nextToken());
			graph[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < k; ++i) {
			stk = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(stk.nextToken());
			int to = Integer.parseInt(stk.nextToken());
			int cost = Integer.parseInt(stk.nextToken());
			
			graph[start].add(new Node(to, cost));
			graph[to].add(new Node(start, cost));
		}
		
		
		int max = 0;
		for(int i = 1; i <= n; ++i) {
		    max = Math.max(max,	dijkstra(i, n, m));
		}
		
		System.out.println(max);
	}
	
	static final int INF = 1234567890;
	private static int dijkstra(int start,int n, int m) {
		
		int[] dist = new int[n+1];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
		pq.add(new Node(start, 0));
		
		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			
			if(curr.cost > dist[curr.to]) continue;
			
			for(Node next : graph[curr.to]) {
				int newCost = next.cost + curr.cost;
				
				if(newCost < dist[next.to]) {
					dist[next.to] = newCost;
					pq.add(new Node(next.to, newCost));
				}
			}
		}
		
		int sum = 0;
		for(int i = 1; i <= n; ++i) {
			if(dist[i] <= m) {
				sum += arr[i];

			}
		}
		return sum;
	}
}