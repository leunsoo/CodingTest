import java.io.*;
import java.util.*;

public class Solution {
	static int H;
	static int W;
	static char[][] map;
	static int currentR;
	static int currentC;

	// 상 하 좌 우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int currDir;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; ++tc) {
			sb.append("#").append(tc).append(" ");
			String[] strs = br.readLine().split(" ");

			H = Integer.parseInt(strs[0]);
			W = Integer.parseInt(strs[1]);

			map = new char[H][W];

			for (int i = 0; i < H; ++i) {
				String str = br.readLine();

				for (int j = 0; j < W; ++j) {
					map[i][j] = str.charAt(j);

					if (map[i][j] == '<' || map[i][j] == '>' || map[i][j] == 'v' || map[i][j] == '^') {
						currentR = i;
						currentC = j;

						switch (map[i][j]) {
						case '^': currDir = 0; break;
						case 'v': currDir = 1; break;
						case '<': currDir = 2; break;
						case '>': currDir = 3;break;
						}

						map[currentR][currentC] = '.';
					}
				}
			}

			int cmdCnt = Integer.parseInt(br.readLine());
			String cmd = br.readLine();
			for (int i = 0; i < cmdCnt; ++i) {
				play(cmd.charAt(i));
			}

			switch (currDir) {
			case 0 : map[currentR][currentC] = '^';
				currDir = 0;
				break;
			case 1 : map[currentR][currentC] = 'v';
				break;
			case 2 : map[currentR][currentC] = '<';
				break;
			case 3 : map[currentR][currentC] = '>';
				break;
			}

			for (int i = 0; i < H; ++i) {
				sb.append(map[i]).append("\n");
			}
		}

		System.out.println(sb);
	}

	private static void play(char cmd) {
		if (cmd == 'S') {
			shoot();
		} else {
			changeDir(cmd);
			move();
		}
	}

	private static void shoot() {
		int bulletR = currentR;
		int bulletC = currentC;
		while (true) {
			bulletR += dr[currDir];
			bulletC += dc[currDir];

			if (bulletR < 0 || bulletC < 0 || bulletR >= H || bulletC >= W || map[bulletR][bulletC] == '#')
				return;

			if (map[bulletR][bulletC] == '*') {
				map[bulletR][bulletC] = '.';
				return;
			}
		}
	}

	private static void move() {
		int nr = currentR + dr[currDir];
		int nc = currentC + dc[currDir];

		if (nr < 0 || nc < 0 || nr >= H || nc >= W || map[nr][nc] != '.')
			return;

		currentR = nr;
		currentC = nc;
	}

	private static void changeDir(char cmd) {
		switch (cmd) {
		case 'U':
			currDir = 0;
			break;
		case 'D':
			currDir = 1;
			break;
		case 'L':
			currDir = 2;
			break;
		case 'R':
			currDir = 3;
			break;
		}
	}
}
