import java.io.*;
import java.util.*;

public class Main {
	static int[] temp;
	static int N;
	static boolean find = false;
	static String answer = "";

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		temp = new int[N];
		temp[0] = 1;

		dfs(1, 1);

		System.out.println(answer);
	}

	private static void dfs(int len, int ex) {
		if(find) return;
		
		for (int i = 1; i <= len / 2; ++i) {
			int cnt = i;
			for (int j = 1; j <= i; ++j) {
				if (temp[len - j] == temp[len - j - i])
					cnt--;
			}

			if (cnt == 0)
				return;
		}

		if (len == N) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < N; ++i) {
				sb.append(temp[i]);
			}

			answer = sb.toString();
			find = true;
			return;
		}

		for (int i = 1; i <= 3; ++i) {
			if (i == ex)
				continue;

			temp[len] = i;
			dfs(len + 1, i);
		}
	}
}
