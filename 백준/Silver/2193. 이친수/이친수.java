import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		long[][] dp = new long[91][2];
		
		dp[1][0] = 0;
		dp[1][1] = 1;
		
		for(int i = 2; i <= 90; ++i) {
			dp[i][0] = dp[i-1][0]+dp[i-1][1];
			dp[i][1] = dp[i-1][0];
		}
		
		System.out.println(dp[num][0] + dp[num][1]);
	}
}
