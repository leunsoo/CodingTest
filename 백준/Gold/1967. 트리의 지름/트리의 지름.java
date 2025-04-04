import java.io.*;
import java.util.*;

class Node {
	int node;
	int cost;
	
	Node(int node, int cost) {
		this.node = node;
		this.cost = cost;
	}
}

public class Main {
	static ArrayList<Node>[] graph;
	static boolean[] visited;
	static int N; 
	static int max;
	static int maxCost;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[N+1];
		visited = new boolean[N+1];
		max = 0;
		maxCost = 0;
		
		for(int i = 0; i <= N; ++i) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < N-1; ++i) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(stk.nextToken());
			int c = Integer.parseInt(stk.nextToken());
			int cost = Integer.parseInt(stk.nextToken());
			
			maxCost = Math.max(cost, maxCost);
			
			graph[p].add(new Node(c, cost));
			graph[c].add(new Node(p, cost));
		}
		
		for(int i = 1; i <= N; ++i) {
			visited[i] = true;
			dfs(i, 0);
			visited[i] = false;
		}
		
		System.out.println(max);
	}
	
	private static void dfs(int curr, int sum) {	
		max = Math.max(max, sum);
		
		for (Node next : graph[curr]) {
			if(visited[next.node]) continue;
			
			visited[next.node] = true;
			dfs(next.node, sum + next.cost);
			visited[next.node] = false;
		}
	}
}
