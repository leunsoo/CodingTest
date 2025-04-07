import java.io.*;
import java.util.*;

class Edge {
	int to, capacity, flow; 
    Edge reverse;
	
	public Edge(int to, int capacity) {
		this.to = to;
		this.capacity = capacity;
	}
	
	int residual() { // 남은 용량
		return capacity - flow;
	}
	
	void addFlow(int f) {
		flow += f;
        reverse.flow -= f;
	}
}

public class Main {
    static int N;
    static List<Edge>[] graph;
    static int answer;
    static final int LENGTH = 53;

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        graph = new ArrayList[LENGTH];
        for (int i = 0; i < LENGTH; i++) {
            graph[i] = new ArrayList<>();
        }
        
        answer = 0;
        
        for(int i = 0; i < N; ++i) {
        	StringTokenizer stk = new StringTokenizer(br.readLine());
        	char from = stk.nextToken().charAt(0);
        	char to = stk.nextToken().charAt(0);
        	int capacity = Integer.parseInt(stk.nextToken());
        	
        	int f = '0';
        	int t = '0';
        	
        	if(Character.isUpperCase(from)) {
        		f = from - 'A';
        	}
        	else {
				f = from - 'a' + 26;
			}
        	
        	if(Character.isUpperCase(to)) {
        		t = to - 'A';
        	}
        	else {
				t = to - 'a' + 26;
			}
        	
        	Edge forward = new Edge(t, capacity);
        	Edge bacward = new Edge(f, capacity);
        	forward.reverse = bacward;
        	bacward.reverse = forward;
        	graph[f].add(forward);
        	graph[t].add(bacward);	
        }
        
        System.out.println(maxFlow(0, 'Z'-'A'));
    }
    
    private static int maxFlow(int start, int to) {
    	int total = 0;
    	Edge[] path = new Edge[LENGTH];
    	
    	while (bfs(start, to, path)) {
    		int flow = Integer.MAX_VALUE;
    		
    		for(int i = to; i != start; i = path[i].reverse.to) {
    			flow = Math.min(flow, path[i].residual());
    		}
    		
    		for(int i = to; i != start; i = path[i].reverse.to) {
    			path[i].addFlow(flow);
    		}
    		
    		total += flow;
		}
    	
    	return total;
    }
    
    private static boolean bfs(int start, int to, Edge[] path) {
    	Queue<Integer> queue = new ArrayDeque<>();
    	queue.add(start);
    	
    	boolean[] visited = new boolean[LENGTH];
    	visited[start] = true;
    	
    	while (!queue.isEmpty()) {
			int curr = queue.poll();
			
			for(Edge e : graph[curr]) {
				if(!visited[e.to] && e.residual() > 0) {
					visited[e.to] = true;
					path[e.to] = e;
					queue.add(e.to);
					if(e.to == to) return true;
				}
			}
		}	
    	
    	return false;
    }
}
