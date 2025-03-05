import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		char[][] normal = new char[N][N];
		char[][] special = new char[N][N];
		
		for(int i = 0; i < N; ++i) {
			String str = br.readLine();
			for(int j = 0; j < N; ++j) {
				char c = str.charAt(j);
				
				normal[i][j] = c;
				special[i][j] = c == 'G' ? 'R' : c;
			}
		}
		
		System.out.println(bruteforce(normal) + " " + bruteforce(special));
	}
	
	private static int bruteforce(char[][] arr)
	{
		boolean[][] visited = new boolean[arr.length][arr.length];
		int cnt = 0;
		
		for(int i = 0; i < arr.length; ++i) {
			for(int j = 0; j < arr.length; ++j) {
				if(visited[i][j]) continue;
				
				bfs(arr, visited, i, j);
				cnt++;
			}
		}
	
		return cnt;
	}

	
	//상하좌우 
	private static int[] dr = { -1, 1, 0, 0 };
	private static int[] dc = { 0, 0, -1, 1 };
	private static void bfs(char[][] arr, boolean[][] visited, int i, int j) {
		visited[i][j] = true;
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { i, j });
		
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			
			for(int d = 0; d < 4; ++d) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];
				
				if(nr < 0 || nc < 0 || nr >= arr.length || nc >= arr.length) continue;
				if(visited[nr][nc]) continue;
				if(arr[curr[0]][curr[1]] != arr[nr][nc]) continue;
				
				queue.add(new int[] { nr, nc });
				visited[nr][nc] = true;
			}
		}
	}
 }
