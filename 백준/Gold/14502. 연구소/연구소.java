import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;
	static int max = 0;
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);

		map = new int[N][M];

		for (int i = 0; i < N; ++i) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; ++j) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}

		dfs(0);

		System.out.println(max);
	}

	static void dfs(int cnt) {
		if (cnt == 3) {
			bfs();
			return;
		}

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if (map[i][j] != 0)
					continue;

				map[i][j] = 1;
				dfs(cnt + 1);
				map[i][j] = 0;
			}
		}
	}

	// 상하좌우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static void bfs() {
		boolean[][] visited = new boolean[N][M];
		int sum = 0;
		
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if (map[i][j] != 0 || visited[i][j])
					continue;

				ArrayDeque<int[]> queue = new ArrayDeque<>();
				queue.add(new int[] { i, j });
				visited[i][j] = true;
				boolean isSafe = true;
				int cnt = 1;

				while (!queue.isEmpty()) {
					int[] curr = queue.poll();
					if (map[curr[0]][curr[1]] == 2)
						isSafe = false;
					
					for (int d = 0; d < 4; ++d) {
						int nr = curr[0] + dr[d];
						int nc = curr[1] + dc[d];

						if (nr < 0 || nc < 0 || nr >= N || nc >= M)
							continue;
						if (map[nr][nc] == 1 || visited[nr][nc])
							continue;

						queue.add(new int[] { nr, nc });
						visited[nr][nc] = true;
						cnt++;
					}
				}

				if (isSafe) {
					sum += cnt;
				}
			}
		}
		
		if(max < sum) max = sum;
	}
}
