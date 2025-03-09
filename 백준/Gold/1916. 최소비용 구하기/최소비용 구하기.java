import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
	int idx; 
	int cost;
	
	public Node(int idx, int cost) {
		this.idx = idx;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node o) {
		return this.cost - o.cost;
	}
}

public class Main {
	private static List<Node>[] graph; // 도시별 출발 가능한 버스를 저장할 그래프 
	private static int[] dist; // 해당 도시까지 가는데 드는 비용 
	
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int N = Integer.parseInt(br.readLine());
		 int M = Integer.parseInt(br.readLine());
		 
		 graph = new ArrayList[N+1];
		 dist = new int[N+1];
		 
		 for(int i = 0; i <= N; ++i) {
			 graph[i] = new ArrayList<Node>();
		 }
		 
		 Arrays.fill(dist, Integer.MAX_VALUE);
		 
		 for(int i = 0; i < M; ++i) {
			 StringTokenizer stk = new StringTokenizer(br.readLine());
			 int start = Integer.parseInt(stk.nextToken());
			 int end = Integer.parseInt(stk.nextToken());
			 int cost = Integer.parseInt(stk.nextToken());
			 
			 //그래프의 출발점 인덱스에 도착점,비용 노드들 넣어주기 
			 graph[start].add(new Node(end, cost));
		 }
		 
		 String[] str = br.readLine().trim().split(" ");
		 int start = Integer.parseInt(str[0]);
		 int end = Integer.parseInt(str[1]);
		 
		 dijkstra(start);
		 
		 System.out.println(dist[end]);
	}
	
	private static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start,0));
		dist[start] = 0;
		
		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			int idx = curr.idx;
			int cost = curr.cost;
			
			// 도달 비용이 기존 도달 비용보다 비싸면 Pass
			if(cost > dist[idx]) continue;
			
			// 인접 노드 탐색
			for (Node node : graph[idx]) {
				int nCost = dist[idx] + node.cost; // 인접 노드까지 가는 비용 계산 
				if(nCost < dist[node.idx]) // 최소 비용 발견 시 
				{
					dist[node.idx] = nCost; // 최소 비용 갱신 
					pq.add(new Node(node.idx, nCost)); // 노드 넣어주기
				}
			}
		}
	}
}

