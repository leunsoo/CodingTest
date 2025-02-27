import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		long[][] dp = new long[101][10];
		
		Arrays.fill(dp[1], 1);
		dp[1][0] = 0;
		
		for(int i = 2; i <= 100; ++i) {
			for(int j = 0; j <= 9; ++j) {
				if( j == 0) { // 0은 아래로 못가
					dp[i][j] = dp[i-1][j+1]%1000000000;
				}
				else if( j == 9) { // 9는 위로 못가
					dp[i][j] = dp[i-1][j-1]%1000000000;
				}
				else
					dp[i][j] = (dp[i-1][j-1]+dp[i-1][j+1])%1000000000;
			}
		}
		
		long answer = 0;
		for(int i = 0; i <= 9; ++i) {
			answer += dp[N][i];
		}
		
		System.out.println(answer%1000000000);
		
	}
}
