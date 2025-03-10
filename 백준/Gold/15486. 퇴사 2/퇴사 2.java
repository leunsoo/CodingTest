import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int N = Integer.parseInt(br.readLine());
		 
		 int[][] arr = new int[N+1][2];
		 int[][] dp = new int[N+1][2]; // 상담을 하냐 안하냐 
		 
		 for(int i = 1; i <= N; ++i) {
			 StringTokenizer stk = new StringTokenizer(br.readLine());
			 int t = Integer.parseInt(stk.nextToken());
			 int c = Integer.parseInt(stk.nextToken());
			 
			 arr[i][0] = t;
			 arr[i][1] = c;
		 }
		 
		 for(int i = 1; i <= N; ++i) {
			 int time = arr[i][0];
			 int cost = arr[i][1];
			 
			 dp[i][0] = Math.max(dp[i][0], dp[i-1][0]);
			 
			 //상담을 하는 경우 
			 if(i+time <= N+1)
				 dp[i][1] = dp[i][0] + cost;
			 
			 // 상담이 끝난 다음날의 기본값을 갱신 
			 if(i+time <= N)
				 dp[i+time][0] = Math.max(dp[i+time][0], dp[i][1]);
		 }
		 
		 int max = 0;
		 for(int i = 1; i <= N; ++i) {
			 if(max < dp[i][1]) max = dp[i][1];
		 }
		 
		 System.out.println(max);
		 
	}
}
