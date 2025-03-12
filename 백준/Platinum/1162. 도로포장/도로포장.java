import java.io.*;
import java.util.*;

// 다익스트라 중 가져가야 할 정보?
// 현재 노드 정보, 현재까지 포장한 도로 갯수, 현재까지 이동한 시간
class State implements Comparable<State> {
	Node node;
	int cnt;
	long dist;
	
	public State(Node node, int cnt, long dist) {
		this.node = node;
		this.cnt = cnt;
		this.dist = dist;
	}
	
	@Override
	public int compareTo(State o) {
		if(this.dist - o.dist > 0) return 1;
		else if(this.dist == o.dist) return 0;
		else return -1;
	}
}

//노드
class Node {
	int idx;
	int cost;
	
	public Node(int idx, int cost) {
		this.idx = idx;
		this.cost = cost;
	}
}

public class Main {
	private static ArrayList<Node>[] graph;
	private static long[][] dp;
	private static int K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken()); // 도시의 수
		int M = Integer.parseInt(stk.nextToken()); // 도로의 수
		K = Integer.parseInt(stk.nextToken()); // 포장할 도로의 수
		//양방향 도로, 걸리는 시간은 100만보다 작거나 같음.
		//도로의 수는 최대 5만개이므로 100만 x 5만은 int형을 넘어감
		
		graph = new ArrayList[N+1];
		dp = new long[N+1][K+1];
		
		//기본값
		for(int i = 0; i <= N; ++i) {
			graph[i] = new ArrayList<Node>();
			Arrays.fill(dp[i], Long.MAX_VALUE);
		}
		
		for(int i = 1; i <= M; ++i) {
			stk = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(stk.nextToken());
			int u = Integer.parseInt(stk.nextToken());
			int w = Integer.parseInt(stk.nextToken());

			graph[v].add(new Node(u, w));
			graph[u].add(new Node(v, w));
		}
		
		
		dijkstra();
		
		// 목적지 도착시 0번부터 K번까지 공사한 경우의 값들 중 최소 시간이 답이다.
		System.out.println(Arrays.stream(dp[N]).min().getAsLong());
	}
	
	//dp[N][K] = N번 노드에 도달 했을 때 K번 포장해서 이동한 최소 시간
	//서울 1번, 포천 N
	private static void dijkstra() {
		PriorityQueue<State> pq = new PriorityQueue<State>();
		pq.add(new State(new Node(1,0), 0, 0));
		dp[1][0] = 0;
		
		while (!pq.isEmpty()) {
			State curr = pq.poll();

			// 현재 경우의 수가 더 큰 경우
			if( curr.dist > dp[curr.node.idx][curr.cnt]) continue;
			
			for (Node node : graph[curr.node.idx]) {
				// 현재 경로 비용이 더 작은 경우 
				if(dp[node.idx][curr.cnt] > curr.dist + node.cost) {
					// dp[N][K]와 비교, 더 작을 시 dp 갱신 및 pq.add	
					dp[node.idx][curr.cnt] = curr.dist + node.cost;
					pq.add(new State(node, curr.cnt, curr.dist + node.cost));
				}
				
				// 현재 경로 비용이 더 큰 경우
				if(dp[node.idx][curr.cnt] <= curr.dist + node.cost) {
					// 공사하고 간다. ( K가 Max면 공사 불가 )
					if(curr.cnt != K)  {
						// 현재까지 포장한 도로 + 1, 현재까지 이동한 시간 + 0
						int cnt = curr.cnt+1;
						// 그래서 다음 K+1번 공사한 경로비용보다 작은 값을 가지게 된다면
						if(dp[node.idx][cnt] > curr.dist) {
							//갱신
							dp[node.idx][cnt] = curr.dist;
							pq.add(new State(node , cnt, curr.dist));
						}
					}
				}
			}
		}
		
	}
}
