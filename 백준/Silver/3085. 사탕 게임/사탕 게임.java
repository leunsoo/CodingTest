import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		char[][] map = new char[N][N];
		for(int i = 0; i < N; ++i) {
			String line = br.readLine();
			for(int j = 0; j < N; ++j) {
				map[i][j] = line.charAt(j);
			}
		}
		
		bruteforece(map);
	}
	
	private static void bruteforece(char[][] map) {
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		
		int answer = 0;
		
		for(int i = 0; i < map.length; ++i) {
			for(int j = 0; j < map.length; ++j) {
				// 상하좌우 체크하기.
				for(int k = 0; k < 4; ++k) {
					int nr = i + dr[k];
					int nc = j + dc[k];
					
					if(nr < 0 || nc < 0 || nr >= map.length || nc >= map.length) continue;
					
					//인접한 문자와 다르다면
					if(map[i][j] != map[nr][nc]) 
					{
						// 교환후 체크하기.
						swap(map, i, j, nr, nc);
						answer = Math.max(answer, countCheck(map));
						//맵 원복 
						swap(map, i, j, nr, nc);
						
						if(answer == map.length) {
							System.out.println(answer);
							return;
						}
					}
				}
			}
		}
		
		System.out.println(answer);
	}
	
	private static void swap(char[][] map, int r, int c, int nr, int nc) {
		char temp = map[r][c];
		map[r][c] = map[nr][nc];
		map[nr][nc] = temp;
	}
	
	private static int countCheck(char[][] map) {
		int max = 0;
		// 각 행 오른쪽 방향 탐색
		for(int i = 0; i < map.length; ++i) {
			int cnt = 1;
			for(int j = 0; j < map.length-1; ++j) {
				if(map[i][j] == map[i][j+1]) 
				{
					cnt++;
					
					if( j == map.length-2) max = Math.max(max, cnt);
				}
				else {
					max = Math.max(max, cnt);
					cnt = 1;
				}
			}
		}
		
		// 각 열 아래쪽 방향 탐색
		for(int i = 0; i < map.length; ++i) {
			int cnt = 1;
			for(int j = 0; j < map.length-1; ++j) {
				if(map[j][i] == map[j+1][i]) 
				{
					cnt++;
					
					if( j == map.length-2) max = Math.max(max, cnt);
				}
				else {
					max = Math.max(max, cnt);
					cnt = 1;
				}
			}
		}
		
		return max;
	}
}
