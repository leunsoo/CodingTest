import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	
	// 상 우 하 좌
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int currDir;
	static int currR;
	static int currC;
	static boolean[][] walls;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		
		stk = new StringTokenizer(br.readLine());
		currR = Integer.parseInt(stk.nextToken());
		currC = Integer.parseInt(stk.nextToken());
		currDir = Integer.parseInt(stk.nextToken());
		
		walls = new boolean[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; ++i) {
			stk = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; ++j) {
				//1은 벽 0은 청소되지 않는 빈칸
				walls[i][j] = stk.nextToken().equals("1") ? true : false;
				visited[i][j] = walls[i][j];
			}
		}
		
		System.out.println(clean());
	}
	
	private static int clean() {
		int cnt = 0;
		
		//로봇 청소기는 다음과 같이 작동한다.
		while (true) {
			// 1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
			if(!visited[currR][currC]) { 
				visited[currR][currC] = true;
				cnt++;
			}
			
			int check = 0;
			//주변 4칸 체크
			for(int i = 0; i < 4; ++i) {
				int nr = currR + dr[i];
				int nc = currC + dc[i];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc]) continue;
				
				check++;
			}

			if(check == 0) { // 2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우,
				
				int reverseDir = (currDir + 2) % 4;
				int nr = currR + dr[reverseDir];
				int nc = currC + dc[reverseDir];

				// 1. 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
				if(!walls[nr][nc]) {
					currR = nr;
					currC = nc;
					continue;
				}
				// 2. 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
				else return cnt;
			}
			else { 
				// 3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우,
				// 1. 반시계 방향으로 $90도 회전한다.
				currDir--;
				currDir = currDir < 0 ? 3 : currDir;
				// 2. 바라보는 방향을  기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
				int nr = currR + dr[currDir];
				int nc = currC + dc[currDir];

				if(nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc]) continue;
				currR = nr;
				currC = nc;
				
				// 3. 1번으로 돌아간다.	
			}
		}
	}

}
