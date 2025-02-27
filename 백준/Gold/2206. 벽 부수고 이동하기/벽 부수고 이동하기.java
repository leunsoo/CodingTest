import java.io.*;
import java.util.*;
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		int N = Integer.parseInt(strs[0]);
		int M = Integer.parseInt(strs[1]);
		
		int[][] map = new int[N][M];
		
		
		//맵 셋팅
		for(int i = 0; i < N; ++i ) {
			String str = br.readLine();
			for(int j = 0; j < M; ++j) 
			{
				map[i][j] =	str.charAt(j)-'0';
			}
		}
		
		System.out.println(bfs(map, N-1, M-1));
	
	}
	
			
	private static int bfs(int[][] map, int targetR, int targetC) {
		boolean[][][] visited = new boolean[map.length][map[0].length][2];
	
		//4방향 상하좌우
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		
		// 큐 시작
		Queue<int[]> queue = new ArrayDeque<>();
		// 시작 위치, 거리, 벽 부신 횟수
		queue.add(new int[] { 0, 0, 1, 0 });
		visited[0][0][0] = true;
		
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			
			if(curr[0] == targetR && curr[1] == targetC) {
				return curr[2];
			}
			
			// 현재 위치에서 모든 방향 탐색
			for(int i = 0; i < 4; ++i) {
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];
				
				if(nr < 0 || nc < 0 || nr >= map.length || nc >= map[0].length) continue;
				if(visited[nr][nc][curr[3]]) continue; // visited pass

				// 해당 방향에 벽이 있다면 breakCnt 체크
				if(map[nr][nc] == 1) {
					// breakCnt == 0 => breakCnt += 1 해주고 넘겨주기
					if(curr[3] == 0) {
						queue.add(new int[] {nr, nc, curr[2]+1, 1 });
						visited[nr][nc][1] = true;
					}
					else { // breakCnt == 1 => 끝
						continue;
					}
				}
				else // 해당 방향에 벽이 없다면 그냥 넣어줌
				{
					queue.add(new int[] {nr, nc, curr[2]+1, curr[3] });
					visited[nr][nc][curr[3]] = true;
				}
			}
			
		}
		
		// 못돌면 -1			
		return -1;
	}
}
