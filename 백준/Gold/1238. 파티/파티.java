import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
	int idx;
	int cost;
	
	Node(int idx, int cost) {
		this.idx = idx;
		this.cost = cost;
	}
	
	//가장 많은 시간을 소비 = 최고 비용
	@Override
	public int compareTo(Node o) {
		return this.cost-o.cost;
	}
}

//최고비용 구하기 
public class Main {
	static ArrayList<Node>[] graph; //정점들을 저장할 그래프
	static int[] dist; //비용을 저장할 배열
	static int[] temp;
	static int[] distToX; 
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(stk.nextToken()); // 정점 개수
		int M = Integer.parseInt(stk.nextToken()); // 간선 개수
		int X = Integer.parseInt(stk.nextToken()); // 시작점 ( 해당 노드부터의 최대비용 ) 		
		
		graph = new ArrayList[N+1];
		dist = new int[N+1];
		distToX = new int[N+1];
		
		for(int i = 1; i <= N; ++i) {
			graph[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}
		
		//단방향 그래프
		for(int i = 0; i < M; ++i) {
			stk = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(stk.nextToken());
			int end = Integer.parseInt(stk.nextToken());
			int cost = Integer.parseInt(stk.nextToken());
			
			graph[start].add(new Node(end,cost));
		}
		
		//X부터 각각의 집들까지
		dijkstra(X, -1, dist);
		
		//각각의 집들부터 x까지 
		for(int i = 1; i <= N; ++i) {
			if(i == X) continue;
			temp = new int[N+1];
			Arrays.fill(temp, Integer.MAX_VALUE);
			distToX[i] = dijkstra(i, X, temp);
		}
		
		for(int i = 1; i <= N; ++i) {
			dist[i] += distToX[i];
		}
		
		System.out.println(Arrays.stream(dist).max().getAsInt());
	}
	
	
	private static int dijkstra(int start, int end, int[] _dist) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		_dist[start] = 0;
		
		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			int idx = curr.idx;
			int cost = curr.cost;
			
			// 이미 최고 비용이 있을 시 continue
			if(_dist[idx] < cost) continue;
			
			if(idx == end) {
				return cost;
			}
			
			// 최고 비용 가능 시 인접 노드 ㄱ
			for (Node node : graph[idx]) {
				int nCost = _dist[idx] + node.cost;
				if(nCost > _dist[node.idx]) continue;
				
				pq.add(new Node(node.idx, nCost));
				_dist[node.idx] = nCost;
			}
		}
		
		return -1;
	}
}

