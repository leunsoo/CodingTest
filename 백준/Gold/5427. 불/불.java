import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int T = Integer.parseInt(br.readLine());
    	
    	for(int tc = 1; tc <= T; ++tc) {
    		StringTokenizer stk = new StringTokenizer(br.readLine());
    		int w = Integer.parseInt(stk.nextToken());
    		int h = Integer.parseInt(stk.nextToken());
    		
    		char[][] map = new char[h][w];
    		
    		ArrayDeque<int[]> fires = new ArrayDeque<>(); 
    		int[] start = new int[2];
    		
    		for(int i = 0; i < h; ++i) {
    			String str = br.readLine();
    			for(int j = 0; j < w; ++j) {
    				char c = str.charAt(j);
    				
    				if(c == '@') {
    					start[0] = i;
    					start[1] = j;
    				}
    				else if(c == '*') {
    					fires.add(new int[] { i, j });
    				}
    				
    				map[i][j] = c;
    			}
    		}
    		
    		System.out.println(bfs(fires, start, map, h, w));
    	}
    }
    
    //상하좌우
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };
    
    private static String bfs(ArrayDeque<int[]> fires, int[] start, char[][] map, int h, int w) {
    	boolean[][] visited = new boolean[h][w];
    	Queue<int[]> queue = new ArrayDeque<>();
    	queue.add(start);
    	visited[start[0]][start[1]] = true;
    	int time = 0;
    	
    	while (!queue.isEmpty()) {
        	// 불 먼저
    		int fireSize = fires.size();
    		for(int i = 0; i < fireSize; ++i) {
    			int[] currFire = fires.poll();
    			
    			for(int d = 0; d < 4; ++d) {
    				int nr = currFire[0] + dr[d];
    				int nc = currFire[1] + dc[d];
    				
    				if(nr < 0 || nc < 0 || nr >= h || nc >= w) continue;
    				if(map[nr][nc] == '#' || map[nr][nc] == '*') continue;
    				
    				map[nr][nc] = '*';
    				fires.add(new int[] { nr, nc });
    			}
    		}

        	// 그 후 상근
    		int size = queue.size();
    		for(int i = 0; i < size; ++i) {
    			int[] curr = queue.poll();

    			for(int d = 0; d < 4; ++d) {
    				int nr = curr[0] + dr[d];
    				int nc = curr[1] + dc[d];

    				if(nr < 0 || nc < 0 || nr >= h || nc >= w) { // 탈출
    					return Integer.toString(time+1);
    				}
    				
    				if(map[nr][nc] == '#' || visited[nr][nc] || map[nr][nc] == '*') continue;
    				
    				queue.add(new int[] {nr, nc});
    				visited[nr][nc] = true;
    			}
    		}
    		
    		time++;
		}
    			
    	return "IMPOSSIBLE";
    }
}
