import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken()); // 나무의 수
        int M = Integer.parseInt(stk.nextToken()); // 필요한 나무의 길이

        int[] trees = new int[N];
        stk = new StringTokenizer(br.readLine());

        int maxHeight = 0;
        for(int i = 0; i < N; ++i) {
            trees[i] = Integer.parseInt(stk.nextToken());
            maxHeight = Math.max(maxHeight, trees[i]);
        }

        int result = parametricSearch(trees, M, maxHeight);
        System.out.println(result);
    }

    //조건을 만족하는 최대 절단기 높이 반환
    private static int parametricSearch(int[] trees, int targetLength, int maxHeight) {
        int left = 0; // 절단기 높이의 최솟값
        int right = maxHeight; // 절단기 높이의 최댓값
        int answer = 0; // 조건을 만족하는 최대 높이

        while (left <= right) {
            int mid = (left + right) / 2; // 절단기 높이 설정

            // 현재 절단기 높이로 얻을 수 있는 나무의 총 길이 계산
            long cutLength = calculateCutLength(trees, mid);

            if(cutLength >= targetLength) {
                // 목표량을 달성할 수 있다면, 절단기에 더 높은 높이를 설정할 수 있나 확인
                answer = mid;
                left = mid+1;
            }
            else {
                // 목표량을 달성할 수 없다면, 더 낮은 높이에서 탐색
                right = mid-1;
            }
        }

        return answer;
    }

    // 현재 절단기 높이로 얻을 수 있는 나무의 총 길이 계산
    private static long calculateCutLength(int[] trees, int cutHeight) {
        long totalLength = 0;

        for(int treeHeight : trees) {
            // 나무가 절단기보다 높을 때만 잘린다
            if(treeHeight > cutHeight) {
                totalLength += (treeHeight - cutHeight);
            }
        }

        return totalLength;
    }

}