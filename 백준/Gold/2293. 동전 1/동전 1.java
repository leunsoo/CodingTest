import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int k = Integer.parseInt(str[1]);
		
		int[] arr = new int[n];
		int[] dp = new int[k+1];
		
		for(int i = 0; i < n; ++i) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dp[0] = 1;
		
		for(int i = 0; i < n; ++i) { 
			for(int j = arr[i]; j <= k ; j++) {
				// 기존에 계산된 동전이 있고 현재 동전을 추가할 수 있다면 
				if(dp[j-arr[i]] != 0) { 
					dp[j] += dp[j-arr[i]];
 				}
				
				// 현재 가치가 가능한 동전이 없는데 현재 동전은 가능하다면 
				if(dp[j] == 0) { 
					// 현재 동전으로 게산될 수 있다면
					if(j%arr[i] == 0)  
						dp[j] = 1; //1로 설정 
				}
				
			}
		}
		
		System.out.println(dp[k]);
	}
}
