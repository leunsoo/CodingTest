import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static int[][] arr;
	static boolean[][] visited;
	static int max = 0;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());

		arr = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; ++i) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; ++j) {
				int num = Integer.parseInt(stk.nextToken());
				arr[i][j] = num;
				if (max < num)
					max = num;
			}
		}

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				memory[0][0] = i;
				memory[0][1] = j;
				visited[i][j] = true;
				dfs(1, i, j, arr[i][j]);
				visited[i][j] = false;
			}
		}

		System.out.println(answer);
	}

	// 상하좌우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] memory = new int[4][2];

	private static void dfs(int cnt, int r, int c, int value) {
		if (value + (4 - cnt) * max < answer )
			return;
		
		if (cnt == 4) {
			if (value > answer)
				answer = value;

			return;
		}


		for(int i = 0; i < cnt; ++i) {
			for (int d = 0; d < 4; ++d) {
				int nr = memory[i][0] + dr[d];
				int nc = memory[i][1] + dc[d];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc])
					continue;

				visited[nr][nc] = true;
				memory[cnt][0] = nr;
				memory[cnt][1] = nc;
				dfs(cnt + 1, nr, nc, value + arr[nr][nc]);
				visited[nr][nc] = false;
			}
		}
	}
}
