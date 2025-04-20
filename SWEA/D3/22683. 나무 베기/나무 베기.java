import java.io.*;
import java.util.*;

class Car {
	int r;
	int c;
	int dir;
	int cut;
	int cmd;
	
	public Car(int r, int c, int dir, int cut, int cmd) {
		this.r = r;
		this.c = c;
		this.dir = dir;
		this.cut = cut;
		this.cmd = cmd;
	}
	
	// 상 우 하 좌 
	private int[] dr = { -1, 0, 1, 0 };
	private int[] dc = { 0, 1, 0, -1 };
	
	public int getLeftDir() {
		if(dir - 1 < 0) return 3;
		return dir - 1;
	}
	
	public int getRightDir() {
		if(dir + 1 > 3) return 0;
		return dir + 1;
	}
	
	public int[] getMovePos() {
		return new int[] { r + dr[dir], c + dc[dir] };
	}
}

public class Solution {
	static char[][] map;
	static int K;
	static int N;
	
	static int startR;
	static int startC;
	static int targetR;
	static int targetC;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= T; ++tc) {
			sb.append("#").append(tc).append(" ");
			
			String[] strs = br.readLine().split(" ");
			N = Integer.parseInt(strs[0]);
			K = Integer.parseInt(strs[1]);
			
			map = new char[N][N];
			
			for(int i = 0; i < N; ++i) {
				String str = br.readLine();
				for(int j = 0; j < N; ++j) {
					map[i][j] = str.charAt(j);
					
					if(map[i][j] == 'X') {
						startR = i;
						startC = j;
					}
					else if(map[i][j] == 'Y') {
						targetR = i;
						targetC = j;
					}
				}
			}
			
			sb.append(bfs()).append("\n");
		}
		
		System.out.println(sb);
	}
	
	private static int bfs() {
		Queue<Car> queue = new ArrayDeque<>();
		queue.add(new Car(startR, startC, 0, 0, 0));
		
		// r, c, 나무 벤 횟수, 방향 = 조작횟수  
		int[][][][] visited = new int[N][N][K+1][4];
		visited[startR][startC][0][0] = 0;
		
		while (!queue.isEmpty()) {
			Car curr = queue.poll();
			
			if(curr.r == targetR && curr.c == targetC) {
				return curr.cmd;
			}
			
			//이동 가능?
			int[] nextPos = curr.getMovePos();
			if(nextPos[0] >= 0 && nextPos[1] >= 0 && nextPos[0] < N && nextPos[1] < N) {
				if(map[nextPos[0]][nextPos[1]] == 'T' && curr.cut < K) {
					if(visited[nextPos[0]][nextPos[1]][curr.cut+1][curr.dir] == 0 || curr.cmd + 1 < visited[nextPos[0]][nextPos[1]][curr.cut+1][curr.dir]) {
						visited[nextPos[0]][nextPos[1]][curr.cut+1][curr.dir] = curr.cmd+1;
						queue.add(new Car(nextPos[0], nextPos[1], curr.dir, curr.cut+1, curr.cmd+1));
					}
				}
				else if((map[nextPos[0]][nextPos[1]] != 'T' && visited[nextPos[0]][nextPos[1]][curr.cut][curr.dir] == 0) || ( map[nextPos[0]][nextPos[1]] != 'T' && curr.cmd + 1 < visited[nextPos[0]][nextPos[1]][curr.cut][curr.dir])) {
					visited[nextPos[0]][nextPos[1]][curr.cut][curr.dir] = curr.cmd+1;
					queue.add(new Car(nextPos[0], nextPos[1], curr.dir, curr.cut, curr.cmd+1));
				}
			}
				
			//왼쪽 가능?
			if( visited[curr.r][curr.c][curr.cut][curr.getLeftDir()] == 0 || curr.cmd+1 < visited[curr.r][curr.c][curr.cut][curr.getLeftDir()]) {
				visited[curr.r][curr.c][curr.cut][curr.getLeftDir()] = curr.cmd+1;
				queue.add(new Car(curr.r, curr.c, curr.getLeftDir(), curr.cut, curr.cmd+1));
			}
			
			//오른쪽 가능?
			if( visited[curr.r][curr.c][curr.cut][curr.getRightDir()] == 0 || curr.cmd+1 < visited[curr.r][curr.c][curr.cut][curr.getRightDir()]) {
				visited[curr.r][curr.c][curr.cut][curr.getRightDir()] = curr.cmd+1;
				queue.add(new Car(curr.r, curr.c, curr.getRightDir(), curr.cut, curr.cmd+1));
			}			
		}
		
		return -1;
	}
	
}

