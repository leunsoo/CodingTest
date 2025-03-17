import java.io.*;
import java.util.*;

class Node implements Comparable<Node> { 
	int id;
	int next;
	int cost;
	boolean isShortPath;
	ArrayList<Node> footPrint;
	
	public Node(int id, int next, int cost) {
		this.id = id;
		this.next = next;
		this.cost = cost;
		footPrint = new ArrayList<Node>();
	}
	
	@Override
	public int compareTo(Node o) {
		return this.cost - o.cost;
	}
}

public class Main {
	private static ArrayList<Node>[] graph; 
	private static boolean[] isShortPath;
	private static ArrayList<Node> path;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(stk.nextToken()), M = Integer.parseInt(stk.nextToken());
			
			if(N == 0 && M == 0) break;
			
			stk = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(stk.nextToken()), D = Integer.parseInt(stk.nextToken());
			
			graph = new ArrayList[N];
			isShortPath = new boolean[N];
			path = new ArrayList<>();
			
			for(int i = 0; i < N; ++i)
			{
				graph[i] = new ArrayList<Node>();
			}
			
			for(int i = 0; i < M; ++i) {
				stk = new StringTokenizer(br.readLine());
				
				int u = Integer.parseInt(stk.nextToken());
				int v = Integer.parseInt(stk.nextToken());
				int p = Integer.parseInt(stk.nextToken());
				
				graph[u].add(new Node(u, v, p));
			}
			
			findShort(S, D);
			checkShort();
			isShortPath[S] = false;
			isShortPath[D] = false;
			System.out.println(findNearest(S, D));
		}
	}

	static int[] dist;
	static ArrayList<Node> duplCheck;
	private static void findShort(int start, int end) {
		dist = new int[graph.length];
		duplCheck = new ArrayList<>();
		Arrays.fill(dist, Integer.MAX_VALUE);
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, start, 0));
		dist[start] = 0;
		
		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			//최단 경로들 체크하기

			if(curr.cost > dist[curr.next]) continue;
			
			for (Node node : graph[curr.next]) {
				int newCost = node.cost + curr.cost;

				if(newCost <= dist[node.next]) {
					Node newNode = new Node(node.id ,node.next, newCost);
					newNode.footPrint.addAll(curr.footPrint);
					newNode.footPrint.add(newNode);
					if(newCost == dist[node.next])
					{
						duplCheck.add(newNode);
					}
					else {
						pq.add(newNode);
						dist[node.next] = newCost;
					}
				}
				
				if(node.next == end) { 
					if(newCost <= dist[end]) {
						Node newNode = new Node(node.id, node.next, newCost);
						newNode.footPrint.addAll(curr.footPrint);
						newNode.footPrint.add(newNode);
						
						path.add(newNode);
					}
				}
			}
		}
	}
	
	private static void checkShort() {
		if(path.size() == 0) return;
		
		Collections.sort(path, (o1, o2)-> o1.cost - o2.cost );
		int minCost = path.get(0).cost;
		for(int i = 0; i < path.size();++i) {
			if(path.get(i).cost == minCost) {
				Node node = path.get(i);
				for (Node n : node.footPrint) {
					for(int j = graph[n.id].size()-1; j >= 0; --j) {
						if(graph[n.id].get(j).next == n.next) {
							graph[n.id].remove(j);
						}
					}	
				}
			}
			else {
				break;
			}
		}

		for(int d = 0; d < duplCheck.size(); ++d) {
			Node node = duplCheck.get(d);
			for(int j = graph[node.id].size()-1; j >= 0; --j) {
				if(graph[node.id].get(j).next == node.next) {
					graph[node.id].remove(j);
				}
			}	
		}	
	}
	
	private static int findNearest(int start, int end) {
		int[] dist = new int[graph.length];
		Arrays.fill(dist, Integer.MAX_VALUE);
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(-1, start,0));
		dist[start] = 0;
		int cost = -1;
		
		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			//최단 경로들 체크하기
			if(curr.next == end) {
				return curr.cost;
			}
			
			if(curr.cost > dist[curr.next]) continue;
			
			for (Node node : graph[curr.next]) {
				int newCost = node.cost + curr.cost;
				
				if(newCost < dist[node.next]) {
					pq.add(new Node(node.id, node.next, newCost));
					dist[node.next] = newCost;
				}
			}
		}
		return cost;
	}
	
}
