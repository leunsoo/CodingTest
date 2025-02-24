import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<int[]> arr = new ArrayList<int[]>();
	static int M;
	static int[][] map;
	static int[][] temp;
	static boolean[] visited;
	static int[][] save;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		map = new int[N][N];
		M = Integer.parseInt(str[1]);
		temp = new int[M][2];
		save = new int[N][N];
		arr.clear();
		answer = Integer.MAX_VALUE;
		
		for(int i = 0; i < N; ++i) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; ++j) {
				int num = Integer.parseInt(stk.nextToken());
				map[i][j] = num;

				//1. 모든 2 좌표 저장
				if(num == 2) {
					arr.add(new int[] { i, j });
				}
			}
		}
		
		visited = new boolean[arr.size()];
		
		recursive(0,0);
		
		
		System.out.println(answer);
	}
	
	//2. 저장한 좌표중에 M개를 고른 N개의 경우 뽑기
	private static void recursive(int cnt,int idx)
	{
		if(cnt == M) {
			split();
			return;
		}
		
		for(int i = 0; i < arr.size(); ++i) {
			if(visited[i] || i < idx) continue;
		
			visited[i] = true;
			temp[cnt] = arr.get(i);
			recursive(cnt+1, i);
			visited[i] = false;
		}	
	}
	
	private static void split()
	{			
		for(int i = 0; i < map.length; ++i) {
			for(int j = 0; j < map.length; ++j)
			{
				if(map[i][j] != 1) continue;
				
				int min = Integer.MAX_VALUE;
				//3. 해당 경우의 수 별로 가까운 거리 구하기
				for(int k = 0; k < temp.length; ++k) {
					int r = Math.abs(i - temp[k][0]);
					int c = Math.abs(j - temp[k][1]);
					
					if(min > r+c) min = r+c;
				}
	
				save[i][j] = min;
			} 
		}

		int sum = 0;
		for(int i = 0; i < map.length; ++i) {
			for(int j = 0; j < map.length; ++j) {
				if(save[i][j] == 0) continue;
				
				sum += save[i][j];
			}
		}
		
		if(answer > sum) 
			answer = sum;
		
	}
}
