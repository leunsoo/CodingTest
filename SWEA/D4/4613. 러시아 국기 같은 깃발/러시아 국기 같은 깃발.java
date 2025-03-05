import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine().trim());

		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; ++tc) {
			String[] strs = br.readLine().trim().split(" ");

			int N = Integer.parseInt(strs[0]); // 행
			int M = Integer.parseInt(strs[1]); // 열

			int[][] colors = new int[N][3]; // 0 = 해당 행의 하얀색 개수, 1 = 해당 행의 파란색 개수, 2 해당 행의 뻘건색 개수
			for (int i = 0; i < N; ++i) {
				int[] colorCnt = getColorsCount(br.readLine());
				colors[i][0] = colorCnt[0];
				colors[i][1] = colorCnt[1];
				colors[i][2] = colorCnt[2];
			}

			int answer = Integer.MAX_VALUE;
			// 모든 색깔의 조합
			for (int i = 0; i < N - 2; ++i) {
				for (int j = i + 1; j < N - 1; ++j) {
					int sum = 0;

					// 흰색 계산
					for (int row = 0; row <= i; ++row) {
						sum += M - colors[row][0];
					}
					// 파란색 계산
					for (int row = i + 1; row <= j; ++row) {
						sum += M - colors[row][1];
					}
					// 빨간색 계산
					for (int row = j + 1; row < N; ++row) {
						sum += M - colors[row][2];
					}

					if (answer > sum) answer = sum;
				}
			}
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static int[] getColorsCount(String str) {
		// 0 = 하얀색 개수, 1 = 파란색 개수, 2 = 뻘건색 개수
		int[] colors = new int[3];
		for (int i = 0; i < str.length(); ++i) {
			char c = str.charAt(i);

			switch (c) {
				case 'W': colors[0]++; break;
				case 'B': colors[1]++; break;
				case 'R': colors[2]++; break;
			}
		}

		return colors;
	}
}
