import java.io.*;
import java.util.*;

class Enemy {
	int r;
	int c;
	int dist;
	boolean killed;
	
	public Enemy(int r, int c) {
		this.r = r;
		this.c = c;
		this.dist = 0;
		this.killed = false;
	}
}

public class Main {
	static int N;
	static int M;
	static int D;
	static ArrayList<Enemy> enemys;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		D = Integer.parseInt(stk.nextToken());
		
		enemys = new ArrayList<>();
		
		for(int i = 0; i < N; ++i )
		{
			stk = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; ++j) {
				if(stk.nextToken().equals("1")) {
					enemys.add(new Enemy(i, j));
				}
			}
		}
		
		int max = 0;
		for(int i = 0; i < M; ++i) {
			for(int j = i+1; j < M; ++j) {
				for(int k = j+1; k < M; ++k) {
					max = Math.max(max, simulate(i,j,k));
				}
			}
		}
		
		System.out.println(max);
	}
	
	private static int simulate(int ac1, int ac2, int ac3)
	{
		int[][] poses = { { N, ac1 }, { N, ac2 }, { N, ac3 } };
		
		int cnt = 0;
		ArrayList<Enemy> copy = new ArrayList<>();
		
		//초기적들 상태저장
		for (Enemy enemy : enemys) {
			copy.add(new Enemy(enemy.r, enemy.c));
		}
		
		while (copy.size() > 0 ){
			//공격
			for(int i = 0; i < 3; ++i) { // 궁수 3명
				int minDist = Integer.MAX_VALUE;
				ArrayList<Integer> killedEnemy = new ArrayList<>();
				
				// 모든 적 탐색 
				for(int j = 0; j < copy.size(); ++j) {
					copy.get(j).dist = -1;
					int dist = (Math.abs(poses[i][0] - copy.get(j).r) + Math.abs(poses[i][1] - copy.get(j).c));
					//사거리 체크
					if(dist <= D) {	
						minDist = Math.min(minDist, dist);
						copy.get(j).dist = dist;
						killedEnemy.add(j);
					}	
				}
				
				int curr = Integer.MAX_VALUE;
				int target = -1;
				//사격 가능한 적들
				for (Integer idx : killedEnemy) {
					//가장 가까운적
					if(minDist == copy.get(idx).dist) {
						// 가장 왼쪽에 있는 녀석 찾기
						if(curr > copy.get(idx).c ) {
							curr = Math.min(copy.get(idx).c, curr);	
							target = idx;
						}
					}
				}
				
				// 가장 가깝고 가장 왼쪽에 있는 적 공격
				if(target != -1) {
					copy.get(target).killed = true;
				}
			}
			
			//죽은 애들 없애기
			for(int i = copy.size()-1; i >= 0; --i) {
				if(copy.get(i).killed) {
					cnt++;
					copy.remove(i);
				}
			}
			
			//이동
			for(int i = copy.size()-1; i >= 0; --i) {
				copy.get(i).r++;
				
				if(copy.get(i).r >= N) copy.remove(i);
			}
		}		
		
		return cnt;
	}

}
