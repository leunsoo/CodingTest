
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	int[][] map = new int[n][n];
    	boolean[][] visited = new boolean[n][n];
    	
    	for(int i = 0; i < n; ++i)
    	{
    		String str = br.readLine();
    		for(int j = 0; j < n; ++j)
    		{
    			map[i][j] = str.charAt(j) - '0';
    		}
    	}
    
    	// 상, 하, 좌, 우 
    	int[] dr = new int[] { 1, -1, 0, 0 }; 
    	int[] dc = new int[] { 0, 0, -1, 1 }; 
    	
    	int answer = 0;
    	List<Integer> answers = new ArrayList<>();
    	for(int i = 0; i < n; ++i)
    	{
    		for(int j = 0; j < n; ++j)
    		{
    			if(map[i][j] == 0 || visited[i][j]) continue; 
    			
    			Queue<int[]> queue = new LinkedList<int[]>();
    			
    			int houseCnt = 1;
    			answer++;
    			
    			queue.add(new int[] {i, j});
    			visited[i][j] = true;
    			
    			while (!queue.isEmpty()) {
    				int[] curPos = queue.poll();
    				
    				for(int k = 0; k < 4; ++k)
    				{
    					int nr = curPos[0] + dr[k];
    					int nc = curPos[1] + dc[k];
    					
    					//맵밖으로 나갈 시
    					if(nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
    					//확인한 적이 있는 곳일 시 
    					if(visited[nr][nc] || map[nr][nc] == 0) continue;
    					
    					visited[nr][nc] = true;
    					queue.add(new int[] {nr,nc} );
    					houseCnt++;
    				}
    				
				}
    			
    			answers.add(houseCnt);
    		}
    	}
    	
    	Collections.sort(answers);
    	StringBuilder sb = new StringBuilder();
    	sb.append(answer).append("\n");
    	for(int i = 0; i < answers.size(); ++i) {
        	sb.append(answers.get(i)).append("\n");
    	}
    	System.out.println(sb);
    }
}
