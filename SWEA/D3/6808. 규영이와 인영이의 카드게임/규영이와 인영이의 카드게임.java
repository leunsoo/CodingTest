import java.io.*;
import java.util.*;
 
public class Solution {
    static int[] ky = new int[9]; // 규영이 숫자
    static int[] iy = new int[9]; // 인영이 숫자
 
    static int kyWin; // 규영이 승
    static int iyWin; // 인영이 승
 
    static boolean[] visited;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
 
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; ++tc) {
            visited = new boolean[9];
            kyWin = 0;
            iyWin = 0;
             
 
            boolean[] nums = new boolean[19];
            
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int i = 0; i < 9; ++i) {
                int num =  Integer.parseInt(stk.nextToken());
                ky[i] = num;
                nums[num] = true;
            }
            
            for(int i = 1, idx = 0; i <= 18; ++i) {
            	if(nums[i]) continue;
            	iy[idx++] = i;
            }
             
            dfs(0, 0, 0);
            sb.append("#").append(tc).append(" ").append(kyWin).append(" ").append(iyWin).append("\n");
        }
 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
     
    static int[] dp = { 0, 1, 2, 6, 24 };
    static int score;
 
    private static void dfs(int cnt, int kyScore, int iyScore) {
        if (cnt == 9) {
            if(kyScore > iyScore) kyWin++;
            if(iyScore > kyScore) iyWin++;
            return;
        }
         
        if(cnt >= 5) {
            if(kyScore > 85) {
                kyWin += dp[9-cnt];
                return;
            }
            if(iyScore > 85) {
                iyWin += dp[9-cnt];
                return;
            }
        }
 
        for (int i = 0; i < 9; ++i) {
            if(visited[i]) continue;
             
            visited[i] = true;
            score = ky[cnt] + iy[i];
            if(ky[cnt] > iy[i]) 
                dfs(cnt+1, kyScore + score, iyScore);
            else
                dfs(cnt+1, kyScore, iyScore + score);
             
            visited[i] = false;
        }
    }
}