import java.io.*;
import java.util.*;

public class Main {
	static int[] parent;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer stk = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(stk.nextToken());
    	int M = Integer.parseInt(stk.nextToken());
    	
    	parent = new int[N+1];
    	
    	for(int i = 1; i <= N; ++i) {
    		parent[i] = i;
    	}
    	
    	for(int i = 0; i < M; ++i) {
    		stk = new StringTokenizer(br.readLine());
    		int x = Integer.parseInt(stk.nextToken());
    		int y = Integer.parseInt(stk.nextToken());
    		
    		union(x, y);
    	}
    	
    	int answer = 1;
    	for(int i = 2; i <= N; ++i) {
    		if(!union(1, i)) {
    			answer++;
    		}
    	}
    	
    	System.out.println(answer);
	}
    
    // Find Root
    private static int find(int x) {
		if(parent[x] == x) {
			return x;
		}
		
		return parent[x] = find(parent[x]);
	}
    
    // Integration
    private static boolean union(int x, int y) {
    	int rootX = find(x);
    	int rootY = find(y);
    	
    	if(rootX == rootY) {
    		return true;
    	}
    	
    	parent[rootX] = rootY;
    	return false;
	}
}