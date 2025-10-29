import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static char[][] arr;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);
		
		arr = new char[N][M];
		visited = new boolean[N][M];
		
		int startR = 0, startC = 0;
		for(int i = 0; i < N; ++i) {
			String str = br.readLine();
			for(int j = 0; j < M; ++j) {
				char c =  str.charAt(j);
				arr[i][j] = c;
				
				if(c == 'I') {
					startR = i;
					startC = j;
				}
			}
		}
		
		int res = GetMeetablePeopleCount(startR, startC);
		System.out.println(res != 0 ? res : "TT");
	}
	
	//상, 하, 좌, 우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	
	private static int GetMeetablePeopleCount(int startR, int startC) {
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		int meetCount = 0;
		
		dq.add(new int[] {startR, startC} );
		visited[startR][startC] = true;
		
		while (!dq.isEmpty()) {
			int[] curr = dq.poll();
			
			for(int i = 0; i < 4; ++i) {
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				if(visited[nr][nc] || arr[nr][nc] == 'X') continue;
				
				dq.add(new int[] {nr, nc});
				visited[nr][nc] = true;
				
				if(arr[nr][nc] == 'P') meetCount++;
			}
		}
		
		return meetCount;
	}
}