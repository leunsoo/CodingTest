import java.io.*;
import java.util.*;

//최소 비용을 계산할 정점들 
class Node implements Comparable<Node>{
	int friend; // 연결되어 있는 노드
	int cost; // 연결되어 있는 노드까지 가는 비용
	
	Node(int friend, int cost) {
		this.friend = friend;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Node o) { // 비용 오름차순
		return this.cost - o.cost;
	}
}

public class Main {
	static ArrayList<Node>[] graph; // 노드들을 담을 그래프 
	static int[] dist; // 해당 노드까지의 경로 비용을 가지고 있을 배열 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		int V = Integer.parseInt(strs[0]); // 정점의 개수
		int E = Integer.parseInt(strs[1]); // 간선의 개수
		
		int start = Integer.parseInt(br.readLine()); // 시작 노드
		
		graph = new ArrayList[V+1]; 
		dist = new int[V+1];
		
		//그래프, 경로 비용 배열 초기화 
		for(int i = 0; i <= V; ++i) {
			graph[i] = new ArrayList<Node>();
			dist[i] = Integer.MAX_VALUE;
		}
		
		for(int i = 0; i < E; ++i) { // 그래프 - 노드 정보 저장
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(stk.nextToken());
			int v = Integer.parseInt(stk.nextToken());
			int w = Integer.parseInt(stk.nextToken());

			graph[u].add(new Node(v, w));
		}
		
		// 다익스트라 알고리즘 - 최소비용 경로 찾기
		dijkstra(start);
		
		// 해당 노드까지 출력 => 비용가지고 있는 배열 순회
		// 시작점 자신은 0으로 출력 , 경로가 존재하지 않는 경우에는 INF 출력
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= V; ++i) {
			if(dist[i] == Integer.MAX_VALUE) {
				sb.append("INF").append("\n");
				continue;
			}
			sb.append(dist[i]).append("\n");
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		bw.write(sb.toString());
		bw.flush();
	}
	
	
	private static void dijkstra(int start) {
		// 우선순위 큐 
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(start, 0));
		dist[start] = 0;
		
		// 큐가 빌때까지 반복
		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			int idx = curr.friend;
			int cost = curr.cost;

			// 현재 꺼낸 노드의 경로 비용이 더 적은 경로가 존재할 경우 넘어간다.
			if(dist[idx] < cost) continue;
			
			// 현재 꺼낸 노드가 더 적은 경로 비용을 가질 경우
			// 현재 꺼낸 노드와 인접한 노드들을 탐색한다.
			for (Node node : graph[idx]) {
				// 인접 노드들을 탐색하며 인접노드가 향하는 경로의 비용을 계산한다.
				int nCost = dist[idx] + node.cost;
				// 만약 인접노드가 향하는 노드의 이미 최소경로가 있을 경우 해당 노드는 out
				if(nCost >= dist[node.friend]) continue;

				// 해당 인접노드의 경로가 최소 경로라면 
				// 인접노드가 향하는 노드의 경로 비용 배열의 값을 재설정해주고
				// 우선순위 큐에 넣어준다.
				dist[node.friend] = nCost;
				pq.add(new Node(node.friend, nCost));
			}
		}
	}
}