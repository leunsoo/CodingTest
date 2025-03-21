import java.io.*;
import java.util.*;

public class Main {
	static String[][] map;
	static int R;
	static int C;
	
	static int max = 1;  
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		String[] strs = br.readLine().split(" ");
		R = Integer.parseInt(strs[0]);
		C = Integer.parseInt(strs[1]);
		
		map = new String[R][C];
		
		for(int i = 0; i < R; ++i) {
			String str = br.readLine();
			for(int j = 0; j < C; ++j) {
				map[i][j] = Character.toString(str.charAt(j)); 
			}
		}
		dfs(map[0][0], 0, 0);
		
		System.out.println(max);
	}
	
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	
	static void dfs(String path, int r, int c) {
		if(max < path.length()) max = path.length();
		
		for(int d = 0; d < 4; ++d) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if( nr < 0 || nc < 0 || nr >= R || nc >= C ) continue;
			if(path.contains(map[nr][nc])) continue;

			//문자 저장. 포함여부 확인
			dfs(path+map[nr][nc], nr , nc);
 		}
	}
	
}
