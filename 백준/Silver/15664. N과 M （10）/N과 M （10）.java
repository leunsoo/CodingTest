import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;

	static int[] arr;
	static int[] answerArr;
	static boolean[] visited;

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().trim().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);

		arr = new int[N];
		answerArr = new int[M];
		visited = new boolean[N];

		StringTokenizer stk = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(stk.nextToken());
		}

		Arrays.sort(arr);
		recursive(0,0);

		bw.flush();
		bw.close();
	}

	private static void recursive(int cnt, int num) throws IOException {
		if (cnt == M) {
			for (int i : answerArr) {
				bw.write(i + " ");
			}
			bw.write("\n");
			return;
		}

		int before = 0;
		for (int i = 0; i < N; ++i) 
		{
			if (before == arr[i] || i < num)
				continue;

			before = arr[i];
			answerArr[cnt] = arr[i];
			recursive(cnt + 1, i+1);

		}
	}
}
