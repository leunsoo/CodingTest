
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer stk = new StringTokenizer(br.readLine());
    	int n = Integer.parseInt(stk.nextToken());
    	int m = Integer.parseInt(stk.nextToken());
    	int v = Integer.parseInt(stk.nextToken());
    	boolean[] visited = new boolean[n+1];
    	
    	HashMap<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>(n);
    	
    	//그래프 그리
    	for(int i = 0; i < m; ++i)
    	{
    		stk = new StringTokenizer(br.readLine());
    		int p1 = Integer.parseInt(stk.nextToken());
    		int p2 = Integer.parseInt(stk.nextToken());
    		
    		if(graph.containsKey(p1))
    		{
    			graph.get(p1).add(p2);
    		}
    		else {
				graph.put(p1, new ArrayList<Integer>());
				graph.get(p1).add(p2);
			}

    		
    		if(graph.containsKey(p2))
    		{
    			graph.get(p2).add(p1);
    		}
    		else {
				graph.put(p2, new ArrayList<Integer>());
				graph.get(p2).add(p1);
			}
    	}
    	
    	Dfs(v, graph, visited);
    	visited = new boolean[n+1];
    	Bfs(v, graph, visited);
    }
    
    private static void Dfs(int startP, HashMap<Integer, List<Integer>> graph, boolean[] visited) {
    	
    	StringBuilder sb = new StringBuilder();
    	
    	Stack<Integer> stack = new Stack<>();
    	stack.push(startP);
    	
    	while (!stack.isEmpty()) {
    		int currentP = stack.pop(); //스택에서 꺼낸다.
        	if(visited[currentP]) continue; // 이미 방문한 점일 경우 패쓰 
        	
        	sb.append(currentP).append(" "); // 새로운 점일 경우 방문했다고 출력 
        	visited[currentP] = true;        // 방문기록 true 
    		
    		if(!graph.containsKey(currentP)) continue; //연결된 점이 없다면 Pass
    		Collections.sort(graph.get(currentP),Collections.reverseOrder()); //가장 낮은 숫자부터 
	    	
			for (int connectedP : graph.get(currentP)) {
				stack.push(connectedP);
			}
		}
    	
    	System.out.println(sb);
    	
    }
    
    private static void Bfs(int startP, HashMap<Integer, List<Integer>> graph, boolean[] visited) {

    	StringBuilder sb = new StringBuilder();
    	
    	Queue<Integer> queue = new LinkedList<Integer>();
    	
    	queue.add(startP);
    	
    	while (!queue.isEmpty()) {
    		int currentP = queue.poll(); //스택에서 꺼낸다.
        	if(visited[currentP]) continue; // 이미 방문한 점일 경우 패쓰 
        	
        	sb.append(currentP).append(" "); // 새로운 점일 경우 방문했다고 출력 
        	visited[currentP] = true;        // 방문기록 true 
    		
    		if(!graph.containsKey(currentP)) continue; //연결된 점이 없다면 Pass
    		Collections.sort(graph.get(currentP)); //가장 낮은 숫자부터 
	    	
			for (int connectedP : graph.get(currentP)) {
				queue.add(connectedP);
			}
		}
    	
    	System.out.println(sb);
	}
}
