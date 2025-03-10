import java.io.*;
import java.util.*;

//정점의 정보 
class Node implements Comparable<Node> {
	int idx;
	int cost;
	
	Node(int idx, int cost) {
		this.idx = idx;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return this.cost - o.cost;
	}
}

public class Main {
	static ArrayList<Node>[] graph; //정점들을 저장할 그래프
	static int[] dist; //비용을 저장할 배열
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		int N = Integer.parseInt(strs[0]); // 정점의 개수
		int E = Integer.parseInt(strs[1]); // 간선의 개수
		
		graph = new ArrayList[N+1];
		dist = new int[N+1];
		
		//그래프, 배열 초기화
		for(int i = 0; i <= N; ++i) {
			graph[i] = new ArrayList<Node>();
		}
		
		//그래프에 노드 정보 저장
		for(int i = 0; i < E; ++i) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(stk.nextToken());
			int v = Integer.parseInt(stk.nextToken());
			int w = Integer.parseInt(stk.nextToken());
			graph[u].add(new Node(v, w));
			graph[v].add(new Node(u, w));
		} 
		
		strs = br.readLine().split(" ");
		// 반드시 거쳐야 하는 두 정점 
		int v1 = Integer.parseInt(strs[0]); 
		int v2 = Integer.parseInt(strs[1]);

		
		boolean isBlock1 = false;
		boolean isBlock2 = false;
		// 1 - v1 - v2 - N 경로 탐색
		int answer = 0;
		dijkstra(1, v1);
		if(dist[v1] == Integer.MAX_VALUE) {
			isBlock1 = true;
		}
		answer += dist[v1];
		dijkstra(v1, v2);
		if(dist[v2] == Integer.MAX_VALUE) {
			isBlock1 = true;
		}
		answer += dist[v2];
		dijkstra(v2, N);
		if(dist[N] == Integer.MAX_VALUE) {
			isBlock1 = true;
		}
		answer += dist[N];

		// 1 - v2 - v1 - N 경로 탐색
		int sum = 0;
		dijkstra(1, v2);
		if(dist[v2] == Integer.MAX_VALUE) {
			isBlock2 = true;
		}
		sum += dist[v2];
		dijkstra(v2, v1);
		if(dist[v1] == Integer.MAX_VALUE) {
			isBlock2 = true;
		}
		sum += dist[v1];
		dijkstra(v1, N);
		sum += dist[N];
		if(dist[N] == Integer.MAX_VALUE) {
			isBlock2 = true;
		} 
		
		if(isBlock1 && isBlock2) {
			System.out.println(-1);
		}
		else {
			if(!isBlock1 && !isBlock2)
				answer = sum > answer ? answer : sum;
			else if(isBlock1)
				answer = sum;
				
			System.out.println(answer);
		}
	}
	
	private static void dijkstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		Arrays.fill(dist, Integer.MAX_VALUE); 
		pq.add(new Node(start, 0));
		dist[start] = 0;
		
		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			int idx = curr.idx;
			int cost = curr.cost;
			
			if(cost > dist[idx]) continue;
			
			if(idx == end) break;
			
			for (Node node : graph[idx]) {
				int newCost = dist[idx] + node.cost;
				if(newCost >= dist[node.idx]) continue;
				
				pq.add(new Node(node.idx, newCost));
				dist[node.idx] = newCost;
			}
		}
	}
}