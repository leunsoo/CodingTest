import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 시험지의 개수
        int K = Integer.parseInt(st.nextToken()); // 그룹의 개수
        
        int[] scores = new int[N];
        int totalSum = 0;
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
            totalSum += scores[i];
        }
        
        int result = parametricSearch(scores, K, totalSum);
        System.out.println(result);
    }
    
    // 최솟값의 최댓값을 찾는 함수
    static int parametricSearch(int[] scores, int K, int totalSum) {
        int left = 0;           
        int right = totalSum;  
        int answer = 0;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (canDivide(scores, K, mid)) {
                answer = mid;     
                left = mid + 1;    
            } else {
                right = mid - 1;  
            }
        }
        
        return answer;
    }
    
    //  K개 그룹 가능?
    static boolean canDivide(int[] scores, int K, int minScore) {
        int groups = 0;   
        int currentSum = 0;  
        
        for (int i = 0; i < scores.length; i++) {
            currentSum += scores[i];
            
            if (currentSum >= minScore) {
                groups++;
                currentSum = 0; 
                
                // K개 그룹 가능
                if (groups == K) {
                    return true;
                }
            }
        }
        
        return false; // K개 그룹 불가
    }
}