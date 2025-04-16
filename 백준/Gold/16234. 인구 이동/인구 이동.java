import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int L;
	static int R;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken()); // N x N
		L = Integer.parseInt(stk.nextToken()); // 최소
		R = Integer.parseInt(stk.nextToken()); // 최대
		
		arr = new int[N][N];
		
		for(int i = 0; i < N; ++i) {
			stk = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; ++j) {
				arr[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		System.out.println(open());
	}
	
	
	//상하좌우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	
	// 국경선 열기
	private static int open() {
		int moveCnt = 0;
		
		while (true) {
			boolean[][] visited = new boolean[N][N];
			boolean isMoved = false;
			
			for(int i = 0; i < N; ++i) {
				for(int j = 0; j < N; ++j) {
					if(visited[i][j]) continue;
					
					visited[i][j] = true;
					int sum = arr[i][j]; // 연합의 인구수
					
					Queue<int[]> queue = new ArrayDeque<>();
					queue.add(new int[] { i, j });
					
					Queue<int[]> our = new ArrayDeque<>();
					our.add(new int[] { i, j });
					
					// 국경선 열기
					while (!queue.isEmpty()) {
						int[] curr = queue.poll();

						for(int d = 0; d < 4; ++d ) {
							int nr = curr[0] + dr[d];
							int nc = curr[1] + dc[d];
							
							if(nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc]) continue;
							int diff = Math.abs(arr[curr[0]][curr[1]] - arr[nr][nc]);
							
							if(diff >= L && diff <= R) {
								sum += arr[nr][nc];
								visited[nr][nc] = true;
								queue.add(new int[] { nr, nc });
								our.add(new int[] { nr, nc });
							}
						}
					}
					
					//국경선 열린게 하나라도 있다면
					if(our.size() > 1) {
						isMoved = true;
						move(our, sum);
					}	
				}
			}
			
			if(!isMoved) break;
			
			moveCnt++;	
		}
		
		return moveCnt;
	}
	
	// 인구 이동 => 연합 평준화
	private static void move(Queue<int[]> poses, int sum) {
		int avg = sum/poses.size();
		while(!poses.isEmpty()) {
			int[] curr = poses.poll();
			
			arr[curr[0]][curr[1]] = avg;
		}
	}
}
