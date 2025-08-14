import java.io.*;
import java.util.*;

public class Main {
	private static int N;
	private static int[] arr;
	private static int max;
	private static int limit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(stk.nextToken());
			max = Math.max(max, arr[i]);
		}
		
		limit = Integer.parseInt(br.readLine());
		
		System.out.println(parametricSearch());
	}
	
	private static int parametricSearch() {
		int left = 0;
		int right = max;
		int answer = 0;
		
		while (left <= right) {
			int sum = 0;
			int mid = (left + right)/2;
			
			for(int i = 0; i < N; ++i) {
				if(mid > arr[i]) {
					sum += arr[i];
				}
				else {
					sum += mid;
				}
			}
			
			if(limit >= sum) {
				answer = mid;
				left = mid + 1;
			}
			else {
				right = mid - 1 ;
			}
		}
		return answer;
	}
}