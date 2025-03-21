import java.io.*;
import java.util.*;

public class Main {
	static char[][] map;
	static boolean[] visited; 
	static int R;
	static int C;
	
	static int max = 1;  
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		String[] strs = br.readLine().split(" ");
		R = Integer.parseInt(strs[0]);
		C = Integer.parseInt(strs[1]);
		
		map = new char[R][C];
		visited = new boolean['Z'-'A'+1];
		
		for(int i = 0; i < R; ++i) {
			String str = br.readLine();
			for(int j = 0; j < C; ++j) {
				map[i][j] = str.charAt(j); 
			}
		}
		
		visited[map[0][0]-'A'] = true;
		dfs(1, 0, 0);
		
		System.out.println(max);
	}
	
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	
	static void dfs(int cnt, int r, int c) {
		if(max < cnt) max = cnt;
		
		for(int d = 0; d < 4; ++d) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if( nr < 0 || nc < 0 || nr >= R || nc >= C ) continue;
			if(visited[map[nr][nc]-'A']) continue;
			
			visited[map[nr][nc]-'A'] = true;
			dfs(cnt + 1, nr , nc);
			visited[map[nr][nc]-'A'] = false;
 		}
	}
	
}
