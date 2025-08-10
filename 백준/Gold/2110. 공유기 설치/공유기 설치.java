import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 집의 개수
        int C = Integer.parseInt(st.nextToken()); // 공유기의 개수
        
        int[] houses = new int[N];
        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }
        
        // 집들을 좌표 순으로 정렬
        Arrays.sort(houses);
        
        // 파라메트릭 서치 실행
        int result = parametricSearch(houses, C);
        System.out.println(result);
    }
    
    // 최대 최소 거리를 찾는 함수
    static int parametricSearch(int[] houses, int C) {
        int left = 1; // 최소 거리 (인접한 집 사이 거리)
        int right = houses[houses.length - 1] - houses[0]; // 최대 거리 (양 끝 집 사이 거리)
        int answer = 0;
        
        while (left <= right) {
            int mid = (left + right) / 2; // 현재 확인할 최소 거리
            
            // mid 거리로 C개의 공유기를 설치할 수 있는가?
            if (canInstall(houses, C, mid)) {
                answer = mid;      // 가능하므로 답 후보로 저장
                left = mid + 1;    // 더 큰 거리에서도 가능한지 확인
            } else {
                right = mid - 1;   // 불가능하므로 더 작은 거리에서 확인
            }
        }
        
        return answer;
    }
    
    //주어진 최소 거리로 C개의 공유기를 설치할 수 있는지 확인
    static boolean canInstall(int[] houses, int C, int minDist) {
        int count = 1; // 설치된 공유기 개수 (첫 번째 집에 무조건 설치)
        int lastPos = houses[0]; // 마지막으로 공유기를 설치한 집의 위치
        
        for (int i = 1; i < houses.length; i++) {
            int currentPos = houses[i];
            
            // 마지막 설치 위치로부터 최소 거리 이상 떨어져 있다면
            if (currentPos - lastPos >= minDist) {
                count++;
                lastPos = currentPos;
                
                // 필요한 개수만큼 설치 완료
                if (count >= C) {
                    return true;
                }
            }
        }
        
        return false; // C개를 설치하지 못함
    }
}