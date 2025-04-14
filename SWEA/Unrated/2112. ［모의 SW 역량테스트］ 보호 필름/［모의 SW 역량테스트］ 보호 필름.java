import java.util.*;
import java.io.*;

public class Solution {
	static int K;
	static int D;
	static int W;
	static int[][] arr;
	static int[] A;
	static int[] B;
	
	static int min;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= T; ++tc) {
			sb.append("#").append(tc).append(" ");
			
			StringTokenizer stk = new StringTokenizer(br.readLine());
			D = Integer.parseInt(stk.nextToken());
			W = Integer.parseInt(stk.nextToken());
			K = Integer.parseInt(stk.nextToken());
			
			A = new int[W];
			B = new int[W];
			Arrays.fill(B, 1);
			
			arr = new int[D][W];
			min = K;
			
			for(int i = 0; i < D; ++i) {
				stk = new StringTokenizer(br.readLine());
				for(int j = 0; j < W; ++j) {
					arr[i][j] = Integer.parseInt(stk.nextToken());
				}
			}
			
			dfs(0, 0);
			sb.append(min).append("\n");
		}
		
		System.out.println(sb);
	}

	// 보호필름 경우의 수
	private static void dfs(int cnt, int idx) {
		
		if(idx == D) {
			if(check()) {
				min = Math.min(cnt, min);
			}
			return;
		}
		
		if(cnt > min) return;
		
		
		//현재 경우의 수에 대해
			// 약물을 안넣을수도
			dfs(cnt, idx+1);
			
			// 기존값 저장
			int[] temp = arr[idx];
			
			// A 약물을 넣을 수도
			arr[idx] = A;
			dfs(cnt + 1, idx+1);
			
			// B 약물을 넣을 수도
			arr[idx] = B;
			dfs(cnt + 1, idx+1);
			
			arr[idx] = temp;
	}

	// 성능 검사 함수
	private static boolean check() {
		for(int i = 0; i < W; ++i ) {
			boolean isChecked = false;
			int cnt = 1;
			for(int j = 1; j < D; ++j) {
				if(arr[j-1][i] == arr[j][i])
					cnt++;
				else
					cnt = 1;
				
				if(cnt >= K) {
					isChecked = true;
					break;
				}
			}
			
			if(isChecked == false) {
				return false;
			}
		}
		return true;
	}
}
