import java.io.*;
import java.util.*;

public class Main {
	private static int[] origin;
	private static int[] temp;
	private static long cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(stk.nextToken());
		
		origin = new int[N];
		temp = new int[N];
		
		
		stk = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; ++i) {
			origin[i] = Integer.parseInt(stk.nextToken());
		}
		
		cnt = 0;
		mergeSort(0, N-1);
		
		System.out.println(cnt);
		
	}
	
	private static void mergeSort(int left, int right) {
		// 분할
		if(left >= right) return;
		
		int mid = (left+right)/2;
		
		mergeSort(left, mid);
		mergeSort(mid+1, right);
		
		// 병합 정렬 
		merge(left, mid, right);
	}
	
	private static void merge(int left, int mid, int right) {
		// 구간 비교 
		int l = left;
		int r = mid+1;
		int i = left; // temp의 시작 인덱스 
		
		while (l <= mid && r <= right) {
			if(origin[l] <= origin[r]) {
				temp[i++] = origin[l++];
			}
			else {
				cnt += mid - l + 1;
				temp[i++] = origin[r++];
			}
		}

		// 남은 원소 복사 
		while(l <= mid) {
			temp[i++] = origin[l++];
		}
		while(r <= right) {
			temp[i++] = origin[r++];
		}
		
		// 정렬된 배열 복사 
		for(int idx = left ; idx <= right; ++idx) {
			origin[idx] = temp[idx];
 		}
	}
}