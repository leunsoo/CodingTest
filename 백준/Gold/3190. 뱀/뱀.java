import java.io.*;
import java.util.*;

class Point {
	int r;
	int c;
	
	Point(int r, int c)	{
		this.r = r;
		this.c = c;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		
		//사과
		int appleCnt = Integer.parseInt(br.readLine());
		for(int i = 0; i < appleCnt; ++i) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(stk.nextToken());
			int c = Integer.parseInt(stk.nextToken());
			
			map[r-1][c-1] = 1; 
		}
		
		Queue<Integer> time = new ArrayDeque<>();
		Queue<String> dir = new ArrayDeque<>();
		int dirCnt = Integer.parseInt(br.readLine());
		for(int i = 0; i < dirCnt; ++i) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(stk.nextToken());
			String d = stk.nextToken();
			
			time.add(t);
			dir.add(d);
		}
		
		//오른쪽 아래 왼쪽 위쪽
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };
		
		int curDir = 0;
		
		// 뱀 몸통 
		ArrayDeque<Point> snake = new ArrayDeque<>();
		snake.add(new Point(0, 0));
		
		// 뱀 체크 
		boolean[][] visited = new boolean[N][N];
		visited[0][0] = true;
		
		int curTime = 0;
		int changeDir = time.poll();
		while (true) {
			curTime++;
			
			Point p = snake.peek(); //머리 이동
			int nr = p.r + dr[curDir];
			int nc = p.c + dc[curDir];
			
			//몸통이나 벽에 부딫히면 끝
			if(nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc]) break;
			visited[nr][nc] = true;
			snake.addFirst(new Point(nr, nc));
			
			//사과 냠냠
			if(map[nr][nc] == 1) {
				map[nr][nc] = 0;
			}
			else { // 아니면 꼬리 이동 
				Point tail = snake.pollLast();
				visited[tail.r][tail.c] = false;
			}
			
			if(curTime == changeDir) {
				String change = dir.poll();
				
				if(change.equals("D")) {
					curDir++;
					if(curDir == 4) curDir = 0;
				}
				else {
					curDir--;
					if(curDir == -1) curDir = 3;
				}
				
				if(!time.isEmpty()) {
					changeDir = time.poll();
				}
			}
		}
		
		System.out.println(curTime);
	}
}
