import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
    static int cnt;
    static char[] answer;
    static char[] words;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
        for (int tc = 1; tc <= 10; tc++) {
            int N = Integer.parseInt(br.readLine().trim());

            words = new char[N+1];
            answer = new char[N+1];
            for(int i = 1; i <= N; ++i) {
            	String[] strs = br.readLine().trim().split(" ");
            	words[i] = strs[1].charAt(0);
            }

            cnt = 0; 
            inOrder(1, N);
            bw.append("#" + tc + " ");
            for (int i = 1; i < answer.length; ++i) {
            	bw.append(answer[i]);	
			}
            bw.append('\n');
        }
        bw.flush();
    }

    // 중위 순회 
    private static void inOrder(int i, int N) {
        if (i > N)
            return;
        // L V R
        inOrder(i * 2, N); // L
        answer[++cnt] = words[i]; // V
        inOrder(i * 2 + 1, N); // R
    }
}