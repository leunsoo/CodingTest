import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(stk.nextToken());
		}
		
		int[] sorted = arr.clone();
		Arrays.sort(sorted);
		
		//중복제거
		List<Integer> unique = new ArrayList<>();
		unique.add(sorted[0]);
		for(int i = 1; i < N; ++i) {
			if(sorted[i] != sorted[i-1]) {
				unique.add(sorted[i]);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; ++i) {
			int compressed = Collections.binarySearch(unique, arr[i]); 
			sb.append(compressed).append(" ");
		}
		
		System.out.println(sb);
	}
}