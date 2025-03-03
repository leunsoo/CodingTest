import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] strs = br.readLine().split(" ");
		int N = Integer.parseInt(strs[0]);
		int M = Integer.parseInt(strs[1]);
		
		int[][] arr = new int[N][N];
		
		//사각형 모양 누적합 만들기 
		for(int i = 0; i < N; ++i) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(stk.nextToken());
			
			for(int j = 1; j < N; ++j) {
				arr[i][j] = Integer.parseInt(stk.nextToken()) + arr[i][j-1];
			}
		}
		for(int i = 1; i < N; ++i) {
			for(int j = 0; j < N; ++j) {
				arr[i][j] += arr[i-1][j];
			}
		}
		
		//영역 계산 
		for(int i = 0; i < M; ++i) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			//좌표 정상화 
			int r1= Integer.parseInt(stk.nextToken()) - 1;
			int c1= Integer.parseInt(stk.nextToken()) - 1;
			int r2= Integer.parseInt(stk.nextToken()) - 1;
			int c2= Integer.parseInt(stk.nextToken()) - 1;

			int answer = 0;
			if(r1==0 && c1 == 0) {
				answer = arr[r2][c2];
			}
			else if(c1==0) {
				answer = arr[r2][c2] - arr[r1-1][c2];
			}
			else if(r1==0) {
				answer = arr[r2][c2] - arr[r2][c1-1];
			}
			else {
				answer = arr[r2][c2] - arr[r1-1][c2] - arr[r2][c1-1] + arr[r1-1][c1-1];
			}

			bw.write(answer + "\n");
		}
		
		bw.flush();
	}	
}