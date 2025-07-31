import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        int[][] universes = new int[M][N];
        
        // 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                universes[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 각 우주를 좌표 압축
        for (int i = 0; i < M; i++) {
            compress(universes[i]);
        }
        
        // 브루트포스 비교
        int result = 0;
        for (int i = 0; i < M; i++) {
            for (int j = i + 1; j < M; j++) {
                if (Arrays.equals(universes[i], universes[j])) {
                    result++;
                }
            }
        }
        
        System.out.println(result);
    }
    
    private static void compress(int[] arr) {
        int n = arr.length;
        
        // 원본 배열 복사
        int[] temp = arr.clone();
        
        // 정렬
        Arrays.sort(temp);
        
        // 중복 제거 및 매핑 생성
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 0;
        
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(temp[i])) {
                map.put(temp[i], rank++);
            }
        }
        
        // 원본 배열을 압축된 값으로 변경
        for (int i = 0; i < n; i++) {
            arr[i] = map.get(arr[i]);
        }
    }
}