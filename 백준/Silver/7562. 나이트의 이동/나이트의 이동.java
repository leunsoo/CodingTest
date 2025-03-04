import java.io.*;
import java.util.*;

public class Main {
	// 왼쪽 위 
	static int[] lu1 = { -1, -2 };
	static int[] lu2 = { -2, -1 };
	
	// 오른쪽 위
	static int[] ru1 = { -1, 2 };
	static int[] ru2 = { -2, 1 };
	
	// 왼쪽 아래
	static int[] ld1 = { 1, -2 };
	static int[] ld2 = { 2, -1 };
	
	// 오른쪽 아래
	static int[] rd1 = { 1, 2 };
	static int[] rd2 = { 2, 1 };
	
	static int N;
	static boolean[][] visited;
	static int[][] directions = { lu1, lu2, ru1, ru2, ld1, ld2, rd1, rd2 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; ++tc) {
			N = Integer.parseInt(br.readLine());
			visited = new boolean[N][N];
			
			String[] strs = br.readLine().split(" ");
			int startR = Integer.parseInt(strs[0]);
			int startC = Integer.parseInt(strs[1]);
			
			strs = br.readLine().split(" ");
			int endR = Integer.parseInt(strs[0]);
			int endC = Integer.parseInt(strs[1]);
			
			System.out.println(bfs(new int[]{ startR, startC, 0 }, new int[] { endR, endC }));
		}
	}
	
	private static int bfs(int[] start, int[] end) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(start);
		visited[start[0]][start[1]] = true;
		
		while (true) {
			int[] curr = queue.poll();
			
			//탈출
			if(curr[0] == end[0] && curr[1] == end[1] ) {
				return curr[2];
			}
			
			//방향 탐색
			for (int[] dir : directions) {
				int nr = curr[0] + dir[0];
				int nc = curr[1] + dir[1];

				if( nr < 0 || nc < 0 || nr >= N || nc >= N)	continue;
				if(visited[nr][nc]) continue;
				
				queue.add(new int[] { nr, nc , curr[2]+1 });
				visited[nr][nc] = true;
			}
			
		}
	}
}
