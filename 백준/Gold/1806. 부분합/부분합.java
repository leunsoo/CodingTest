import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int S = Integer.parseInt(stk.nextToken());
		

		ArrayDeque<Integer> arr = new ArrayDeque<>();
		ArrayDeque<Integer> part = new ArrayDeque<>();
		
		stk = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; ++i) {
			arr.addLast(Integer.parseInt(stk.nextToken()));
		}

		int sum = arr.peek(); // 부분합 
		part.addLast(arr.pollFirst()); // 부분 수열
		int cnt = Integer.MAX_VALUE;
		
		if(sum >= S) cnt = 1;
		
		while (!arr.isEmpty()) {
			if(sum >= S) {
				sum -= part.peek();
				part.pollFirst();
			}
			else {
				sum += arr.peek();
				part.addLast(arr.pollFirst());
			}
			
			if(sum >= S && part.size() < cnt) { // 가장 짧은 것
				cnt = part.size();
			}
		}
		
		while (sum >= S) {
			sum -= part.pollFirst();
			
			if(sum >= S && part.size() < cnt) { // 가장 짧은 것
				cnt = part.size();
			}
		}
		
		System.out.println(cnt == Integer.MAX_VALUE ? 0 : cnt);
	}
}
