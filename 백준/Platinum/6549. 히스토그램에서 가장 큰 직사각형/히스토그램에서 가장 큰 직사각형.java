import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line;
        while (!(line = br.readLine()).equals("0")) {
            StringTokenizer stk = new StringTokenizer(line);
            int n = Integer.parseInt(stk.nextToken());

            int[] hist = new int[n];
            for(int i =0; i < n; ++i) {
                hist[i] = Integer.parseInt(stk.nextToken());
            }

            long ans = getMaxArea(hist);
            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }

    private static long getMaxArea(int[] hist) {
        int n = hist.length;
        Stack<Integer> stack = new Stack<>(); // 단조 증가 스택
        long maxArea = 0;

        for(int i = 0; i <= n ; ++i) {
            // 계산을 위한 마지막 처리
            int height = i == n ? 0 : hist[i];

            // 현재 높이보다 큰 막대들을 처리
            while (!stack.isEmpty() && hist[stack.peek()] > height) {
                int h = hist[stack.pop()];

                int width = stack.isEmpty() ? i : i - stack.peek() - 1;

                maxArea = Math.max(maxArea, (long) h * width);
            }

            stack.push(i);
        }

        return maxArea;
    }
}