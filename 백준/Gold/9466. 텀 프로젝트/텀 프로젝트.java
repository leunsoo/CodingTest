import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	static boolean[] visited;
	static int cnt;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int tc = 0; tc < T; ++tc) {
        	int N = Integer.parseInt(br.readLine());
        	
        	arr = new int[N+1];
        	visited = new boolean[N+1];
        	cnt = 0;

        	StringTokenizer stk = new StringTokenizer(br.readLine());
        	
        	for(int i = 1; i <= N; ++i) {
        		arr[i] = Integer.parseInt(stk.nextToken());
        	}
        	
        	for(int i = 1; i <= N; ++i) {
        		if(visited[i]) continue;
        		
        		dfs(i);
        	}
        	
        	System.out.println(N-cnt);
        }
    }
    
    private static void dfs(int curr) {
    	Stack<Integer> stack = new Stack<>();
    	visited[curr] = true;
    	stack.add(curr);
    	
    	int team = 0;
    	while (true) {
    		if(visited[arr[curr]]) { 
    			while (!stack.isEmpty()) {
    				int num = stack.pop();
    				visited[num] = true;
    				team++;
    				
    				if(arr[curr] == num) cnt += team;
				}
    			
    			return;
    		}
			
    		visited[arr[curr]] = true;
			stack.add(arr[curr]);
			curr = arr[curr];
		}
    }
}
