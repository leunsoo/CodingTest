import java.io.*;
import java.util.*;


public class Main {
	static class Point {
		int r;
		int c;
		int cnt;
		
		public Point(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	
	static int n;
	static char[][] arr;
	
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0 , -1, 1 };
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new char[n][n];
		
		for(int i = 0; i < n; ++i) {
			String line = br.readLine();
			for(int j = 0; j < n; ++j) {
				arr[i][j] = line.charAt(j);
			}
		}
		
		System.out.println(bfs());
	}
	
	private static int bfs() {
		boolean[][] visited = new boolean[n][n];
		PriorityQueue<Point> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cnt, o2.cnt));
		pq.add(new Point(0, 0, 0));
		
		visited[0][0] = true;
		
		while (true) {
			Point curr = pq.poll();
			
			if(curr.r == n-1 && curr.c == n-1) {
				return curr.cnt;
			}
			
			for(int i = 0; i < 4; ++i) {
				int nr = curr.r + dr[i];
				int nc = curr.c + dc[i];
				
				if(nr < 0 || nr >= n || nc < 0 || nc >= n || visited[nr][nc]) continue;
				
				if(arr[nr][nc] == '0') {
					pq.add(new Point(nr, nc, curr.cnt+1));
				}
				else {
					pq.add(new Point(nr, nc, curr.cnt));
				}
				visited[nr][nc] = true;
 			}
		}
	}
}