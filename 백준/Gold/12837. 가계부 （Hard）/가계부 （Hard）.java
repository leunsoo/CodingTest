import java.io.*;
import java.util.*;

public class Main {
//	private static int[] origin;
	private static long[] seg;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(stk.nextToken());
		int Q = Integer.parseInt(stk.nextToken());
		
//		origin = new int[N+1];
		seg = new long[N*4];
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < Q; ++i) {
			stk = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(stk.nextToken());
			int p = Integer.parseInt(stk.nextToken());
			int q = Integer.parseInt(stk.nextToken());
			
			if(cmd == 1) {
				update(1, N, p, q, 1);
			}
			else {
				sb.append(query(1, N, p, q, 1)).append("\n");
			}
		}
		
		System.out.println(sb);
	}
	
	private static void update(int s, int e, int target, int value, int idx) {
		if(target < s || e < target) return;
		
		if(target == s && target == e) {
			seg[idx] += value;
			return;
		}
		
		int mid = (s+e)/2;
		update(s, mid, target, value, idx*2);
		update(mid+1, e, target, value, idx*2+1);
		
		seg[idx] = seg[idx*2] + seg[idx*2+1];
	}
	
	private static long query(int s, int e, int qs, int qe, int idx) {
		if(qe < s || e < qs) {
			return 0;
		}
		
		if(qs <= s && e <= qe) {
			return seg[idx];
		}
		
		int mid = (s+e)/2;
		long left = query(s, mid, qs, qe, idx*2);
		long right = query(mid+1, e, qs, qe, idx*2+1);
		
		return left+right;
	}
}