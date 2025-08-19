import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine().toUpperCase(); // 대문자로 변환
        
        int[] count = new int[26];
        for (char c : word.toCharArray()) {
            count[c - 'A']++;
        }
        
        int maxCount = 0;
        char result = '?';
        
        for (int i = 0; i < 26; i++) {
            if (count[i] > maxCount) {
                maxCount = count[i];
                result = (char)('A' + i);
            } else if (count[i] == maxCount && count[i] > 0) {
                result = '?';
            }
        }
        
        System.out.println(result);
    }
}