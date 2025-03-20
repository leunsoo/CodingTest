import java.io.*;
import java.util.*;

public class Main {
	static char[][] map;

	static int N;
	static int M;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);
		map = new char[N][M];

		int cr1, cc1, cr2, cc2;
		cr1 = cc1 = cr2 = cc2 = -1;

		for (int i = 0; i < N; ++i) {
			String str = br.readLine();
			for (int j = 0; j < M; ++j) {
				char c = str.charAt(j);
				map[i][j] = c;

				if (c == 'o') {
					if (cr1 == -1) {
						cr1 = i;
						cc1 = j;
					} else {
						cr2 = i;
						cc2 = j;
					}
				}
			}
		}

		dfs(0, cr1, cc1, cr2, cc2);

		if (min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	private static void dfs(int cnt, int cr1, int cc1, int cr2, int cc2) {
		if (cnt == 10 || cnt > min) {
			return;
		}

		//동전은 동시에 이동한다..
		for (int d = 0; d < 4; ++d) {
			// 동전 1
			// 동전 2
			int dropCnt = 0;
			
			int ncr1 = cr1 + dr[d];
			int ncc1 = cc1 + dc[d];
			
			int ncr2 = cr2 + dr[d];
			int ncc2 = cc2 + dc[d];

			if (ncr1 < 0 || ncc1 < 0 || ncr1 >= N || ncc1 >= M) {
				dropCnt++;
			}
			else if (map[ncr1][ncc1] == '#') 
			{
				ncr1 = cr1;
				ncc1 = cc1;
			}
			
			if (ncr2 < 0 || ncc2 < 0 || ncr2 >= N || ncc2 >= M) {
					dropCnt++;
			} 
			else if (map[ncr2][ncc2] == '#')
			{
				ncr2 = cr2;
				ncc2 = cc2;
			}
			if(dropCnt == 1) {
				if(min > cnt+1) min = cnt+1;
				return;
			}
			else if(dropCnt == 0) {
				dfs(cnt+1, ncr1, ncc1, ncr2, ncc2);
			}
		}
	}
}