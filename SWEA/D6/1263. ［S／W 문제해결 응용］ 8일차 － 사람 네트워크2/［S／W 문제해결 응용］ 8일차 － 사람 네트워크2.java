import java.io.*;
import java.util.*;

public class Solution {
	static final int INFINITY = 987654321;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= T; ++tc) {
			sb.append("#").append(tc).append(" ");
			
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(stk.nextToken()); // 사람 수
			int[][] arr = new int[N][N];
			
			for(int i = 0; i < N; ++i) {
				for(int j = 0; j < N; ++j) {
					int num = Integer.parseInt(stk.nextToken());
					
					if(num == 0) arr[i][j] = INFINITY;
					else arr[i][j] = num;
				}
				arr[i][i] = 0;
			}
			
			sb.append(floyd_warshall(arr)).append("\n");
		}	
		
		System.out.println(sb.toString());
	}
	
	private static int floyd_warshall(int[][] arr) {
		//경 출 도
		for(int j = 0; j < arr.length; ++j ) {
			for(int i = 0; i < arr.length; ++i) {
				for(int k = 0; k < arr.length; ++k) {
					arr[i][k] = Math.min(arr[i][k], arr[i][j] + arr[j][k]);
				}
			}
		}
		
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < arr.length; ++i) {
			int sum = 0;
			for(int j = 0; j < arr.length; ++j) {
				if(i == j ) continue;
				sum += arr[i][j];
			}
			
			min = Math.min(min, sum);
		}
		
		return min;
	}
}
