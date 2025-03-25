import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 수열의 길이
        int S = Integer.parseInt(st.nextToken()); // 목표 합

        // 수열 저장 배열
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

		if (S == 0) {
		    System.out.println(1);
		    return;
		}
		
        // 투 포인터 및 필요한 변수 초기화
        int start = 0, end = 0; // 투 포인터
        int sum = 0; // 현재 부분합
        int minLen = Integer.MAX_VALUE; // 최소 길이를 저장 (초기값은 매우 크게)

        // 투 포인터 탐색 시작
        while (true) {
            if (sum >= S) {
                // 현재 구간의 합이 S 이상인 경우 → 최소 길이 갱신 시도
                minLen = Math.min(minLen, end - start);
                // start를 한 칸 이동하여 구간을 좁힘 (더 짧은 구간을 찾기 위해)
                sum -= arr[start++];
            } else if (end == N) {
                // end가 끝까지 도달한 경우 → 더 이상 탐색 불가
                break;
            } else {
                // 현재 합이 S보다 작은 경우 → end를 한 칸 늘려서 구간 확장
                sum += arr[end++];
            }
        }

        // 조건을 만족하는 부분합 구간이 존재하면 최소 길이 출력
        // 그렇지 않다면 0 출력
        System.out.println(minLen == Integer.MAX_VALUE ? 0 : minLen);
    }
}
