import java.io.*;
import java.util.*;

public class Main {
	static int[] dr = { 0, 0, -1, 1, 0, 0 }; // 상하
	static int[] dc = { 0, 0, 0, 0, -1, 1 }; // 좌우
	static int[] dh = { -1, 1, 0, 0, 0, 0 }; // 위아래

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int maxCol = Integer.parseInt(str[0]);
		int maxRow = Integer.parseInt(str[1]);
		int maxHeigth = Integer.parseInt(str[2]);

		int[][][] map = new int[maxRow][maxCol][maxHeigth];
		Queue<int[]> queue = new ArrayDeque<int[]>();
		int sadTomatoCnt = 0; // 안익은 토마토

		// 철수의 토마토 농장에서는 토마토를 보관하는 큰 창고를 가지고 있다.
		for (int h = 0; h < maxHeigth; ++h) {
			for (int r = 0; r < maxRow; ++r) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				for (int c = 0; c < maxCol; ++c) {
					int num = Integer.parseInt(stk.nextToken());
					map[r][c][h] = num;

					if (num == 1)
						queue.add(new int[] { r, c, h, 0}); // 익은 토마토
					else if (num == 0)
						sadTomatoCnt++; // 안익은 토마토
				}
			}

		}
		// 만약, 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고,
		if (sadTomatoCnt == 0) {
			System.out.println(0);
			return;
		}

		int day = 0;
		while (!queue.isEmpty()) {
			// 보관 후 하루가 지나면, 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다
			// 익은 토마토 꺼내기
			int[] pos = queue.poll();

			for (int i = 0; i < 6; ++i) {
				int nr = pos[0] + dr[i];
				int nc = pos[1] + dc[i];
				int nh = pos[2] + dh[i];

				if (nr < 0 || nr >= maxRow || nc < 0 || nc >= maxCol || nh < 0 || nh >= maxHeigth)
					continue; // 농장 바깥에 있는 경우 pass
				if (map[nr][nc][nh] == -1 || map[nr][nc][nh] == 1)
					continue; // 토마토가 들어있지 않거나, 이미 익은 토마토인 경우 pass

				// 익지 않은 토마토들을 익힌 뒤 넣어준다 .
				map[nr][nc][nh] = 1;
				sadTomatoCnt--;
				day = pos[3]+1;
				queue.add(new int[] { nr, nc, nh, day });
			}
		}

		if (sadTomatoCnt == 0) { // 여러분은 토마토가 모두 익을 때까지의 최소 날짜를 출력해야 한다.
			System.out.println(day);
		} else { // 토마토가 모두 익지는 못하는 상황이면 -1을 출력해야 한다.
			System.out.println(-1);
		}

	}
}