import java.io.*;
import java.util.*;

public class Main {
	static boolean[] row;
	static boolean[] col;
	static boolean[] rd; // 오른쪽 아래 방향 대각선
	static boolean[] ru; // 오른쪽 위 방향 대각선

	static int N;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		answer = 0;

		row = new boolean[N];
		col = new boolean[N];
		rd = new boolean[1 + (N - 1) * 2];
		ru = new boolean[1 + (N - 1) * 2];

		dfs(0);
		System.out.println(answer);
	}

	private static void dfs(int cnt) {
		if (cnt == N) {
			answer++;
			return;
		}

		for (int i = 0; i < N; ++i) {
			if (row[cnt] || col[i] || rd[cnt - i + N - 1] || ru[cnt + i])
				continue;

			row[cnt] = true;
			col[i] = true;
			rd[cnt - i + N - 1] = true;
			ru[cnt + i] = true;

			dfs(cnt + 1);

			row[cnt] = false;
			col[i] = false;
			rd[cnt - i + N - 1] = false;
			ru[cnt + i] = false;
		}
	}
}