import java.io.*;
import java.util.*;

public class Main {
	static class Point {
		int r;
		int c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int N; // 맵 크기 
	static int M; // 승객 
 	static int fuel; // 연료 
	static int[][] arr; // 맵 배열, 벽은 -1 
	
	// 택시 위치 
	static int taxiR = -1;
	static int taxiC = -1;
	
	static Point[] destinations;
	
	public static void main(String[] args) throws IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		fuel = Integer.parseInt(stk.nextToken());
		
		arr = new int[N][N];
		destinations = new Point[M+1];
		
		// 벽 그리기 
		for(int i = 0; i < N; ++i) {
			stk = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < N; ++j) {
				arr[i][j] = stk.nextToken().charAt(0) == '1' ? -1 : 0;
			}
		}
		
		// 택시 위치  
		stk = new StringTokenizer(br.readLine());
		taxiR = Integer.parseInt(stk.nextToken())-1;
		taxiC = Integer.parseInt(stk.nextToken())-1;
		
		// 손님 정보
		for(int i = 1; i <= M; ++i) {
			stk = new StringTokenizer(br.readLine());
			int startR = Integer.parseInt(stk.nextToken());
			int startC = Integer.parseInt(stk.nextToken());
			int endR = Integer.parseInt(stk.nextToken());
			int endC = Integer.parseInt(stk.nextToken());
			
			//손님 세우기 
			arr[startR-1][startC-1] = i;
			//목적지 
			destinations[i] = new Point(endR-1, endC-1);
		}
		
		// 알고리즘 
		boolean isClear = true;
		while (M > 0) {
			int target = findNearest();
			if(target == -1) {
				isClear = false;
				break;
			}
			
			if(!go(destinations[target].r, destinations[target].c)) {
				isClear = false;
				break;
			}
			M--;
		}
		
		// 출력 
		System.out.println(isClear? fuel : -1);
	}
	
	
	// 거리가 같은 경우 행 번호가 작은것, 열번호가 작은것 
	static int[] dr = { -1, 0, 0, 1 };
	static int[] dc = { 0, -1 , 1, 0 };

	// 가장 가까운 손님 찾기
	private static int findNearest() {
		// 출발점에 승객이 있는 경우 
		if(arr[taxiR][taxiC] != 0) {
			int target = arr[taxiR][taxiC];
			arr[taxiR][taxiC] = 0;
			return target;
		}
		
		Queue<Point> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][N];
		
		queue.add(new Point(taxiR, taxiC));
		visited[taxiR][taxiC] = true;
		
		int distance = 0;
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			distance++;
			
			// 연료 부족
			if(distance > fuel) return -1;
			
			// 이번 레벨에서 발견한 승객들
			List<Point> candidates = new ArrayList<>();
			
			for(int i = 0; i < size; ++i) {
				Point curr = queue.poll();
				
				for(int d = 0; d < 4; ++d) {
					int nr = curr.r + dr[d];
					int nc = curr.c + dc[d];
					
					if(isOut(nr, nc)) continue;
					if(cantGo(visited, nr, nc)) continue;
					
					visited[nr][nc] = true;
					
					// 손님 발견
					if(arr[nr][nc] != 0) {
						candidates.add(new Point(nr, nc));
					}
					
					queue.add(new Point(nr, nc));
				}
			}
			
			// 이번 레벨에서 승객을 발견했으면 선택
			if(!candidates.isEmpty()) {
				// 행이 작은 것 우선, 행이 같으면 열이 작은 것 우선
				candidates.sort((a, b) -> {
					if(a.r != b.r) return a.r - b.r;
					return a.c - b.c;
				});
				
				Point selected = candidates.get(0);
				fuel -= distance;
				int target = arr[selected.r][selected.c];
				arr[selected.r][selected.c] = 0;
				taxiR = selected.r;
				taxiC = selected.c;
				
				return target;
			}
		}
		
		return -1;
	}
	
	// 목적지까지 이동
	private static boolean go(int destR, int destC) {
		// 출발지와 도착지가 같은 경우 
	    if(taxiR == destR && taxiC == destC) {
	        return true; 
	    }
	    
		Queue<Point> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][N];
		
		queue.add(new Point(taxiR, taxiC));
		visited[taxiR][taxiC] = true;
		
		int distance = 0;
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			distance++;
			
			// 연료 부족
			if(distance > fuel) return false;
			
			for(int i = 0; i < size; ++i) {
				Point curr = queue.poll();
				
				for(int d = 0; d < 4; ++d) {
					int nr = curr.r + dr[d];
					int nc = curr.c + dc[d];
					
					if(isOut(nr, nc)) continue;
					if(cantGo(visited, nr, nc)) continue;
					
					visited[nr][nc] = true;
					
					// 목적지 도착 
					if(nr == destR && nc == destC) {
						taxiR = destR;
						taxiC = destC;
						fuel -= distance;
						fuel += distance * 2; // 충전
						return true;
					}
					
					queue.add(new Point(nr, nc));
				}
			}
		}
		
		return false;
	}
	
	private static boolean isOut(int nr, int nc) {
		return nr < 0 || nc < 0 || nr >= N || nc >= N;
	}
	
	private static boolean cantGo(boolean[][] visited, int nr, int nc) {
		return visited[nr][nc] || arr[nr][nc] == -1; 
	}
}