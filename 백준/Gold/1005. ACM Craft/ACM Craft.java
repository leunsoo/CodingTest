import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int tc = 0; tc < T; ++tc) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(stk.nextToken());
            int K = Integer.parseInt(stk.nextToken());
            
            ArrayList<Integer>[] graph = new ArrayList[N+1];
            int[] indegrees = new int[N+1]; // 위상 정렬
            int[] cost = new int[N+1]; // 건설 시간
            int[] dp = new int[N+1]; // 해당 건물을 짓는데 최소로 요구되는 시간
            
            stk = new StringTokenizer(br.readLine());
            for(int i = 1; i <= N; ++i) {
            	graph[i] = new ArrayList<Integer>();
            	cost[i] = Integer.parseInt(stk.nextToken());
            }
            
            for(int i = 0; i < K; ++i) {
            	stk = new StringTokenizer(br.readLine());
            	int start = Integer.parseInt(stk.nextToken());
            	int to = Integer.parseInt(stk.nextToken());
            	
            	graph[start].add(to);
            	indegrees[to]++;
            }
           
            topologicalSort(graph, indegrees, cost, dp);
            
            int findIdx = Integer.parseInt(br.readLine());
            System.out.println(dp[findIdx]);
        }
    }
    
    static void topologicalSort(ArrayList<Integer>[] graph, int[] indegrees, int[] cost, int[] dp) {
    	Queue<Integer> queue = new ArrayDeque<>();
    	for(int i = 1; i < indegrees.length; ++i) {
    		if(indegrees[i] == 0) { // 최우선 노드
    			queue.add(i);
    			dp[i] = cost[i];
    		}
    	}
    	
    	while (!queue.isEmpty()) {
			int curr = queue.poll();
			
			for (int to : graph[curr] ) {
				indegrees[to]--;
				
				// 해당 경로로 올 시 건물 비용 체크
				dp[to] = Math.max(dp[to], dp[curr] + cost[to]);
				
				if(indegrees[to] == 0) {
					queue.add(to);
				}
			}
		}
    }
    
}
