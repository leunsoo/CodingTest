import java.io.*;
import java.util.*;

public class Main {
	private static int[] seg;
	private static final int MAX_TASTE = 1_000_000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		seg = new int[MAX_TASTE*4];
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; ++i) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			int cmd = Integer.parseInt(stk.nextToken());
			
			if(cmd == 1) { // 꺼내기 
				int seq = Integer.parseInt(stk.nextToken());
				int taste = query(1, MAX_TASTE, seq, 1);
				sb.append(taste).append("\n");
				update(1, MAX_TASTE, taste, -1, 1);
			}
			else { // 넣기 
				int taste = Integer.parseInt(stk.nextToken());
				int cnt = Integer.parseInt(stk.nextToken());
				update(1, MAX_TASTE, taste, cnt, 1);
			}
		}
		
		System.out.println(sb);
	}
	
	private static void update(int s, int e, int target, int value, int idx) {
		if(target < s || e < target) return;
		
		if(s==e) {
			seg[idx] += value;
			return;
		}
		
		int mid = (s+e)/2;
		update(s, mid, target, value, idx*2);
		update(mid+1, e, target, value, idx*2+1);
		
		seg[idx] = seg[idx*2] + seg[idx*2+1];
	}
	
	private static int query(int s, int e, int seq, int idx) {
		if(s == e) {
			return s;
		}
		
		int mid = (s+e)/2;
		int leftCnt = seg[idx*2];
		
		if(seq <= leftCnt) {
			return query(s, mid, seq, idx*2);
		}
		else {
			return query(mid+1, e, seq-leftCnt, idx*2+1);
		}
	}
}