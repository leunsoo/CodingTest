import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int K = Integer.parseInt(st.nextToken()); // 이미 가지고 있는 랜선의 개수
        int N = Integer.parseInt(st.nextToken()); // 필요한 랜선의 개수
        
        int[] cables = new int[K];
        long maxLength = 0; 
        
        for (int i = 0; i < K; i++) {
            cables[i] = Integer.parseInt(br.readLine());
            maxLength = Math.max(maxLength, cables[i]);
        }
        
        long result = parametricSearch(cables, N, maxLength);
        System.out.println(result);
    }
    
    static long parametricSearch(int[] cables, int N, long maxLength) {
        long left = 1;         
        long right = maxLength;
        long answer = 0;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            
            if (canMake(cables, N, mid)) {
                answer = mid;     
                left = mid + 1;   
            } else {
                right = mid - 1;   
            }
        }
        
        return answer;
    }
    
    static boolean canMake(int[] cables, int N, long length) {
        long count = 0; // 만들 수 있는 랜선 개수
        
        for (int cable : cables) {
            count += cable / length;
        }
        
        return count >= N; // N개 이상 만들 수 있는가?
    }
}