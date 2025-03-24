import java.io.*;
import java.util.*;

public class Main {
	static int[][] dist;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		dist = new int[N + 1][N + 1];
		for (int i = 1; i <= N; ++i) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
			dist[i][i] = 0;
		}

		for (int i = 0; i < M; ++i) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(stk.nextToken());
			int end = Integer.parseInt(stk.nextToken());
			int cost = Integer.parseInt(stk.nextToken());

			dist[start][end] = Math.min(dist[start][end], cost);
		}

		floyWarshall();

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; ++i) {
			for (int j = 1; j <= N; ++j) {
				sb.append(dist[i][j] == Integer.MAX_VALUE ? 0 : dist[i][j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

	static void floyWarshall() {
		for (int k = 1; k <= N; ++k) { // 경유지
			for (int i = 1; i <= N; ++i) { // 출발지
				for (int j = 1; j <= N; ++j) { // 도착지 
					if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
						dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
					}
				}
			}
		}
	}

}
