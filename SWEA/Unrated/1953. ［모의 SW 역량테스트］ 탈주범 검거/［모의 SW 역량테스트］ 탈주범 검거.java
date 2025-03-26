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
	//-------------------------------- 터널 설정 -----------------------------------------
	//구조물이 연결된 방향
	//상하좌우 터널 
	static String[] dir_1 = { "up", "down", "left", "right" };
	//상하 터널
	static String[] dir_2 = { "up", "down" };
	//좌우 터널
	static String[] dir_3 = { "left", "right" };
	//상우 터널
	static String[] dir_4 = { "up", "right" };
	//하우 터널
	static String[] dir_5 = { "down", "right" };
	//하좌 터널
	static String[] dir_6 = { "down", "left" };
	//상좌 터널
	static String[] dir_7 = { "up", "left" };
	
	//터널 번호 별로 관리하기 쉽게 하기
	static String[][] dirs = { {}, dir_1, dir_2, dir_3, dir_4, dir_5, dir_6, dir_7 };
	
	static HashMap<String, int[]> hm_dir = new HashMap<>();    
	static HashMap<String, int[]> hm_tunnel = new HashMap<>();
	
	//초기 설정
	private static void init() {
		//문자 <=> 해당 방향의 좌표 값, ex) "up" => { 1, 0 }
		hm_dir.put("up",    new int[] { -1, 0  });
		hm_dir.put("down",  new int[] { 1, 0 });
		hm_dir.put("left",  new int[] { 0, -1 });
		hm_dir.put("right", new int[] { 0, 1  });

		 //문자 <=> 해당 방향과 연결 가능한 터널, ex) "up" => 위로 뚫린 터널과 연결 가능한 터널들 { 1, 2, 5, 6 } 번
		hm_tunnel.put("up",    new int[] { 1, 2, 5, 6 });
		hm_tunnel.put("down",  new int[] { 1, 2, 4, 7 });
		hm_tunnel.put("left",  new int[] { 1, 3, 4, 5 });
		hm_tunnel.put("right", new int[] { 1, 3, 6, 7  });	
	}
	//----------------------------------------------------------------------------------

	static int N; 		 // 맵의 세로 크기
	static int M;        // 맵의 가로 크기
	static int[][] map;  // 입력 받은 맵
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		init();
		
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= T; ++tc) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			N = Integer.parseInt(stk.nextToken());
			M = Integer.parseInt(stk.nextToken());
			int R = Integer.parseInt(stk.nextToken());
			int C = Integer.parseInt(stk.nextToken());
			int L = Integer.parseInt(stk.nextToken());
			
			map = new int[N][M];
			
			for(int i = 0; i < N; ++i) {
				stk = new StringTokenizer(br.readLine());
				for(int j = 0; j < M; ++j) {
					map[i][j] = Integer.parseInt(stk.nextToken());
				}
			}
			
			sb.append("#").append(tc).append(" ").append(bfs(R, C, L)).append("\n");
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	
	private static int bfs(int r, int c, int l) {
		boolean[][] visited = new boolean[N][M];
		Queue<Point> queue = new ArrayDeque<Point>();
		queue.add(new Point(r, c));
		visited[r][c] = true;
		
		int depth = 0;     // 현재 초
		int placeCnt = 1; // 위치할 수 있는 장소의 개수 
		
		while (true) {
			depth++;
			if(depth == l) return placeCnt; // 경과된 시간에 도달 시 return
			
			//시간별로 계산하기 위함 , 현재 depth에 나올 수 있는 경우의 수
			int size = queue.size();
			for(int i = 0; i < size; ++i) {
				Point curr = queue.poll();
				
				//현재 위치한 터널의 번호를 확인한다.
				int tunnelNo = map[curr.r][curr.c];
				//해당 터널에서 나올 수 있는 방향들
				String[] tunnelDir = dirs[tunnelNo];
				// 방향들을 탐색한다. 
				for (String strDir : tunnelDir) {
					// 해당 방향에 맞는 좌표를 가져온다.
					int[] dir = hm_dir.get(strDir);
					
					int nr = curr.r + dir[0];
					int nc = curr.c + dir[1];
					
					//맵밖으로 나가거나 방문한적 있거나 0이면 Pass
					if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
					if(visited[nr][nc] || map[nr][nc] == 0) continue;
					
					//해당 방향에 위치할 수 있는 터널의 종류들을 가져온다.
					int[] tunnelLst = hm_tunnel.get(strDir);
					for (int no : tunnelLst) {
						// 다음 방향에 위치한 터널이 현재 터널 종류와 같다면 
						if(map[nr][nc] == no)
						{
							//해당 터널을 큐에 넣어준다.
							visited[nr][nc] = true;
							queue.add(new Point(nr, nc));
							placeCnt++; // 장소 추가
							break;
						}
					}
				}
				
			}
		}
	}
	
}
