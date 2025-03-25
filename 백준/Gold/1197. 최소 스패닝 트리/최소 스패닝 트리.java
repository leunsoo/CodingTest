import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
	int to;
	int cost;
	
	public Edge(int next, int cost) {
		this.to = next;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Edge o) {
		return this.cost - o.cost;
	}
}

public class Main {
	static ArrayList<Edge>[] graph;
	static boolean[] visited;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(stk.nextToken());
        int E = Integer.parseInt(stk.nextToken());
        
        graph = new ArrayList[V+1];
        visited = new boolean[V+1];
        
        for(int i = 1; i <= V; ++i) {
        	graph[i] = new ArrayList<Edge>();
        }
        
        for(int i = 0; i < E; ++i) {
        	stk = new StringTokenizer(br.readLine());
        	int start = Integer.parseInt(stk.nextToken());
        	int to = Integer.parseInt(stk.nextToken());
        	int cost = Integer.parseInt(stk.nextToken());
        	
        	graph[start].add(new Edge(to, cost));
        	graph[to].add(new Edge(start, cost));
        }
        
        System.out.println(prim());
    }
    
    private static int prim() {
    	PriorityQueue<Edge> pq = new PriorityQueue<>();
    	pq.add(new Edge(1, 0));
    	int min = 0;
    	
    	while (!pq.isEmpty()) {
			Edge e = pq.poll();

			if(visited[e.to]) continue;
			
			visited[e.to] = true;
			min += e.cost;
			
			for (Edge next : graph[e.to]) {
				if(!visited[next.to]) {
					pq.add(next);
				}
			}
		}
    	
    	return min;
    }
}
