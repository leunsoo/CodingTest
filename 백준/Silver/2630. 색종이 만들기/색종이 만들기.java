import java.io.*;
import java.util.*;

public class Main {
	static int[][] arr;
	static int ans_w;  // 하얀색 종이 개수
	static int ans_b;  // 파란색 종이 개수
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		ans_w = 0;
		ans_b = 0;
		
		for(int i = 0; i < N; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		recursion(0, 0, N);
		
		System.out.println(ans_w);
		System.out.println(ans_b);
	}
	
	private static void recursion(int sr, int sc, int size) {
		if(isSameColor(sr, sc, size)) {
			if(arr[sr][sc] == 0) {
				ans_w++;
			} else {
				ans_b++;
			}
			return;
		}
		
		// 다른 색이 섞여있으면 4등분해서 재귀 호출
		int half = size / 2;
		
		// 왼쪽 위
		recursion(sr, sc, half);
		
		// 오른쪽 위
		recursion(sr, sc + half, half);
		
		// 왼쪽 아래
		recursion(sr + half, sc, half);
		
		// 오른쪽 아래
		recursion(sr + half, sc + half, half);
	}
	
	private static boolean isSameColor(int sr, int sc, int size) {
		int color = arr[sr][sc];
		
		for(int i = sr; i < sr + size; i++) {
			for(int j = sc; j < sc + size; j++) {
				if(arr[i][j] != color) {
					return false;
				}
			}
		}
		
		return true;
	}
}