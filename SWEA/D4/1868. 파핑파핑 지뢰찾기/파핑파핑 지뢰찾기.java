import java.io.*;
import java.util.*;

class Point {
	int r;
	int c;
	
	public Point(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class Solution {
	static int N; 		   // 맵의 크기
	static char[][] map;   // 입력 받은 맵
	static int noBomb; 	   // 지뢰 아닌 칸 개수
	static int bfsCnt;	   // bfs 돌린 횟수 => 8방향에 폭탄이 없을 시
	static boolean[][] visted; // 방문처리
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= T; ++tc) {
			
			//입력 및 초기화 
			N = Integer.parseInt(br.readLine());
			
			map = new char[N][N];
			visted = new boolean[N][N];
			noBomb = 0;
			bfsCnt = 0;
			
			for(int i = 0; i < N; ++i) {
				String str = br.readLine();
				for(int j = 0; j < N; ++j) {					
					map[i][j] =  str.charAt(j);
					
					if(map[i][j] != '*') noBomb++; 
				}
			}
			
			//로직
			bruteforce();
			
			//출력
			// bfs 횟수 + (지뢰가 아닌 칸 - bfs 돌면서 연쇄적으로 표시된 칸 개수 )
			sb.append("#").append(tc).append(" ").append(bfsCnt+noBomb).append("\n");
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	//전 맵을 순환
	private static void bruteforce() {
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < N; ++j) {
				//방문한적 있고 폭탄이라면 continue
				if(map[i][j] != '.' || visted[i][j] ) continue;
				
				bfs(i,j);
			}
		}
	}

	//8방향 상 하 좌 우 왼위 오위 왼아 오아 
	static int[] dr = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };
	
	//너비 우선 탐색
	private static void bfs(int r, int c) {
		if(!checkEightDir(r, c)) return;
		
		//주변에 지뢰가 없는 칸이라면 연쇄작용이 발생한다.
		Queue<Point> queue = new ArrayDeque<>();
		queue.add(new Point(r, c));
		visted[r][c] = true;
		noBomb--; 
		bfsCnt++;
		
		while (!queue.isEmpty()) {
			Point curr = queue.poll();
			
			//8방향 탐색
			for(int d = 0; d < 8; ++d) {
				int nr = curr.r + dr[d];
				int nc = curr.c + dc[d];

				if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
				if(visted[nr][nc] || map[nr][nc] == '*') continue;
				
				visted[nr][nc] = true;
				noBomb--; 
				
				if(checkEightDir(nr, nc)) 
					queue.add(new Point(nr, nc));
			}
		}
	}
	
	//8방향 탐색 => 주변에 지뢰가 없는 칸이라면 true 반환
	private static boolean checkEightDir(int r, int c) {
		for(int d = 0; d < 8; ++d) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
			//주변에 지뢰가 있다면 false;
			if(map[nr][nc] == '*') return false;
		}
		
		//주변에 지뢰가 없는 칸이라면 true
		return true;
	}
}
