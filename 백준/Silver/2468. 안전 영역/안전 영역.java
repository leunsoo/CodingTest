import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		//입력 
		int[][] map = new int[N][N];
		int maxHeight = 0;
		for(int i = 0; i < N; ++i) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; ++j) 
			{
				map[i][j] = Integer.parseInt(stk.nextToken());
				
				if(map[i][j] > maxHeight)
					maxHeight = map[i][j];
			}
		}
		
		//모든 높이 탐색 
		int answer = 0;
		while(maxHeight-- > 0) {
			int cnt = bfs(map, maxHeight);
			if(answer < cnt)
				answer = cnt;
		}
		
		System.out.println(answer);
	}
	
	private static int bfs(int[][] map, int height) {
		boolean[][] visited = new boolean[map.length][map.length];
		int cnt = 0;
		
		//상하좌우 델타 탐색 
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		
		for(int i = 0; i < map.length; ++i) {
			for(int j = 0; j < map.length; ++j) {
				if(map[i][j] <= height || visited[i][j]) continue;
				
				// bfs 시작 
				Queue<int[]> queue = new ArrayDeque<int[]>();
				queue.add(new int[] { i, j });
				visited[i][j] = true;
				cnt++;
				
				//이어진 영역 체크 
				while (!queue.isEmpty()) {
					int[] curr = queue.poll();
					
					for(int d = 0; d < 4; ++d) {
						int nr = curr[0] + dr[d];
						int nc = curr[1] + dc[d];
						
						//맵 밖으로 나갈 시 
						if(nr < 0 || nc < 0 || nr >= map.length || nc >= map.length) continue;
						//현재 체크하는 높이보다 작거나 같을 시 
						if(map[nr][nc] <= height) continue;
						//방문한 적이 있을 시 
						if(visited[nr][nc]) continue;
						
						queue.add(new int[] { nr, nc });
						visited[nr][nc] = true;
					}
				}
			}
		}
		
		return cnt;
	}
}
