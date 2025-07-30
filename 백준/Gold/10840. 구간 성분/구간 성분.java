import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String A = br.readLine().trim();
        String B = br.readLine().trim();
        
        int answer = 0;
        
        // A의 모든 부분 문자열의 문자 구성을 저장
        Map<String, Integer> compositionMap = new HashMap<>();
        
        // A의 모든 부분 문자열 처리
        for (int i = 0; i < A.length(); i++) {
            int[] count = new int[26];
            
            for (int j = i; j < A.length(); j++) {
                count[A.charAt(j) - 'a']++;
                
                String composition = arrayToString(count);
                int length = j - i + 1;
                
                compositionMap.merge(composition, length, Math::max);
            }
        }
        
        // B의 모든 부분 문자열 처리하며 A와 비교
        for (int i = 0; i < B.length(); i++) {
            int[] count = new int[26];
            
            for (int j = i; j < B.length(); j++) {
                count[B.charAt(j) - 'a']++;
                
                String composition = arrayToString(count);
                int length = j - i + 1;
                
                // A에서 같은 구성이 있는지 확인
                if (compositionMap.containsKey(composition)) {
                    int maxLenA = compositionMap.get(composition);
                    int commonMaxLen = Math.min(length, maxLenA);
                    answer = Math.max(answer, commonMaxLen);
                }
            }
        }
        
        System.out.println(answer);
    }

    // 문자 구성을 문자열로 변환
    private static String arrayToString(int[] count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                sb.append((char)('a' + i)).append(count[i]).append(',');
            }
        }
        return sb.toString();
    }
}