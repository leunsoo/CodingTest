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
	static int N; 		 // 맵의 크기
	static char[][] map; // 입력 받은 맵
	static int max;      //최대 덩어리
	static ArrayList<Point>[] days;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= T; ++tc) {
			//입력 및 초기화 
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			max = 1; //처음엔 한덩어리
			
			days = new ArrayList[101]; //100일 체크
			for(int i = 1; i <= 100; ++i) {
				days[i] = new ArrayList<Point>();
			}
			
			for(int i = 0; i < N; ++i) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; ++j) {					
					days[Integer.parseInt(stk.nextToken())].add(new Point(i, j));
				}
			}
			
			int t = 0; //t일 차
			while ( t++ < 100) {
				if(days[t].size() == 0) continue; //해당 날에 녹는 치즈가 없다면 패스
				
				for (Point p : days[t]) {
					map[p.r][p.c] = '1'; // 치즈 먹힘
				}
				
				int cnt = bruteforce();
				max = Math.max(max, cnt);
			}
			
			//출력
			// bfs 횟수 + (지뢰가 아닌 칸 - bfs 돌면서 연쇄적으로 표시된 칸 개수 )
			sb.append("#").append(tc).append(" ").append(max).append("\n");
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static boolean[][] visited; //방문처리
	//완탐
	private static int bruteforce() {
		visited = new boolean[N][N];
		int cnt = 0; // 치즈 덩어리 개수
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < N; ++j) {
				//방문한 적 있거나 먹힌 곳이면 pass
				if(visited[i][j] || map[i][j] == '1') continue;
				
				cnt++; //bfs 시작 => 한 덩어리 체크
				bfs(i,j);
			}
		}
		
		return cnt;
	}
	
	//상하좌우
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	//너비 우선 탐색
	private static void bfs(int r, int c) {
		Queue<Point> queue = new ArrayDeque<Point>();
		queue.add(new Point(r, c));
		visited[r][c] = true;
		
		while (!queue.isEmpty()) {
			Point curr = queue.poll();
			
			for(int d = 0; d < 4; ++d) {
				int nr = curr.r + dr[d];
				int nc = curr.c + dc[d];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
				if(visited[nr][nc] || map[nr][nc] == '1') continue;
				
				visited[nr][nc] = true;
				queue.add(new Point(nr, nc));
			}
		}
	}
}
