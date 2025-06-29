import java.io.*;
import java.util.*;

public class Main {
	private static int N, M;
    private static int[] origin, minSeg, maxSeg;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		
		origin = new int[N+1];
		minSeg = new int[(N+1)*4];
		maxSeg = new int[(N+1)*4];
		
		for(int i = 1; i <= N; ++i) {
			origin[i] = Integer.parseInt(br.readLine());
		}
		
		makeSeg(1, 1, N);
		
		for(int i = 0; i < M; ++i) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			
			
			sb.append(querySeg(1, 1, N, a, b, 0));
			sb.append(" ");
			sb.append(querySeg(1, 1, N, a, b, 1));
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	
	static void makeSeg(int index, int s, int e) {
		if(s == e) {
			minSeg[index] = origin[s];
			maxSeg[index] = origin[s];
			return;
		}
		
		int mid = (s+e)/2;
		makeSeg(index*2, s, mid);
		makeSeg(index*2+1, mid+1, e);
		
		minSeg[index] = Math.min(minSeg[index*2], minSeg[index*2+1]);
		maxSeg[index] = Math.max(maxSeg[index*2], maxSeg[index*2+1]);
	}
	
	// 0 = min, 1 = max
	static int querySeg(int index, int s, int e, int qs, int qe, int type) {
		if(qs <= s && e <= qe) {
			if(type == 0) return minSeg[index];
			if(type == 1) return maxSeg[index];
		}
		
		if(qe < s || e < qs) {
			if(type == 0) return Integer.MAX_VALUE;
			if(type == 1) return Integer.MIN_VALUE;
		}
		
		int mid = (s+e)/2;
		int left = querySeg(index*2, s , mid, qs, qe, type);
		int right = querySeg(index*2+1, mid+1, e, qs, qe, type);

		if(type == 0) return Math.min(left, right);
		if(type == 1) return Math.max(left, right);
		
		return 0;
	}
	 
}