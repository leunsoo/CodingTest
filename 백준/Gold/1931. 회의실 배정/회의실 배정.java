import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<int[]> pq = new PriorityQueue<>( new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
		});
		
		StringTokenizer stk;
		for(int i = 0; i < N; ++i) {
			stk = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(stk.nextToken());
			int end = Integer.parseInt(stk.nextToken());
			
			pq.add(new int[] {start, end});
		}
		

		int answer = 1;
		int end = pq.poll()[1]; // 맨처음 끝나는 시간
		
		while (!pq.isEmpty()) {
			int[] next = pq.poll();
			
			if(next[0] >= end) 
			{
				end = next[1];
				answer++;
			}
		}
		
		System.out.println(answer);
	}
}
