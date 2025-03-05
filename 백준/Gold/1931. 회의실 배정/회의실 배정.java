import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
				
		int[][] arr = new int[N][2];
		
		StringTokenizer stk;
		for(int i = 0; i < N; ++i) {
			stk = new StringTokenizer(br.readLine());
			
			arr[i][0] = Integer.parseInt(stk.nextToken());
			arr[i][1] = Integer.parseInt(stk.nextToken());
		}
		
		//끝나는 시간 순으로 오름차순 
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
		});
		
		int answer = 1;
		int start = arr[0][1]; // 맨처음 끝나는 시간
		for(int i = 1; i < N; ++i) {
			if(arr[i][0] >= start) { // 회의 끝난 후 다음 타자 교체 
				start = arr[i][1];
				answer++;
			}
		}
		
		System.out.println(answer);
	}
}
