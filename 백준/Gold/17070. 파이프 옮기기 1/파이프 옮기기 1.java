import java.io.*;
import java.util.*;

public class Main {
	static int cnt = 0;
	static int[][] map;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        map = new int[N][N];
        
        for(int i = 0; i < N; ++i) {
        	StringTokenizer stk = new StringTokenizer(br.readLine());
        	for(int j = 0; j < N; ++j) {
        		map[i][j] = Integer.parseInt(stk.nextToken());
        	}
        }
        
        dfs(0, 1, N, 0);
        
        System.out.println(cnt);
    }
    
    // 오른쪽, 대각선, 아래
    static int[] dr = { 0, 1, 1 };
    static int[] dc = { 1, 1, 0 };
    
    private static void dfs(int r, int c, int N, int exDir) {
    	if(r == N-1 & c == N-1) {
    		cnt++;
    		return;
    	}
    	
    	int start = 0;
    	int end = 0;
    	if(exDir == 0) { // 오른쪽
    		start = 0;
    		end = 2;
    	}
    	else if(exDir == 1) { // 대각선
			start = 0;
			end = 3;
    	}
    	else { // 아래
    		start = 1;
    		end = 3;
		}
    	
    	for(int d = start; d < end; ++d) {
    		int nr = r;
    		int nc = c;
    		if(d==1) { //대각선 3방향 체크
    			boolean flag = true;
    			
    			for(int i = 0; i < 3; ++i) {
        	    	nr = r + dr[i];
        	    	nc = c + dc[i];
        	    	
    	    		if(nr >= N || nc >= N || map[nr][nc] == 1) flag = false;
    			}
    			
    			if(flag) dfs(r+1, c+1, N, d);
    		}
    		else {
    	    	nr = r + dr[d];
    	    	nc = c + dc[d];
    	    	
        		if(nr >= N || nc >= N || map[nr][nc] == 1) continue;
        		
        		dfs(nr, nc, N, d);
			}
    	}
    }
    
}
