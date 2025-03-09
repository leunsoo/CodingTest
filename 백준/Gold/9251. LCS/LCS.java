import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();
        
        int[][] dp = new int[A.length()+1][B.length()+1];
        
        //첫번째 줄의 i 번째와
        //두번쨰 줄의 j 번째를 비교한다.  
        for(int i = 1; i <= A.length(); ++i) {
        	for(int j = 1; j <= B.length(); ++j) {
        		if(A.charAt(i-1) == B.charAt(j-1)) { // 같다면 
                    //i-1번째와 j-1번째 글자까지 확인한 최대 LCS 길이에 +1을 해준다.
        			dp[i][j] = dp[i-1][j-1] + 1;  
        		}
        		else { // 다르다면 이전 값을 불러온다.
                    //i-1번째 글자가 j번 글자까지 확인했을때의 LCS 길이와
                    //i번째 글자가 j-1번 글자까지 확인했을때의 LCS 길이 중
        			dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]); // 최대 길이값을 가져온다. 
        		}
        	}
        }
        System.out.println(dp[A.length()][B.length()]);
    }
}
