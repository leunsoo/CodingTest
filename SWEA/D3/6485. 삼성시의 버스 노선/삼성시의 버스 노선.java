import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int busLines = Integer.parseInt(br.readLine());
            int[] A = new int[busLines];
            int[] B = new int[busLines];
            for (int i = 0; i < busLines; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                A[i] = Integer.parseInt(st.nextToken());
                B[i] = Integer.parseInt(st.nextToken());
            }
  
            int busStopCnt = Integer.parseInt(br.readLine());
            int[] busStops = new int[busStopCnt];
            for (int i = 0; i < busStopCnt; i++) {
                busStops[i] = Integer.parseInt(br.readLine());
            }
            
            int[] countingArr = new int[5001];
 
            for(int i = 0; i < busLines; ++i) {
            	for(int j = A[i]; j <= B[i]; ++j) {
            		countingArr[j]++;
            	}
            }
            
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < busStopCnt; i++) {
                sb.append(countingArr[busStops[i]]).append(" ");
            }
            System.out.println("#"+t+" "+sb);
        }
    }
}