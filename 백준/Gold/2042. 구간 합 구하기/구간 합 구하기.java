import java.io.*;
import java.util.*;

public class Main {
	static long[] arr;
	static long[] tree;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(stk.nextToken()); // 원소 개수
		int M = Integer.parseInt(stk.nextToken()); // 수 변경  
		int K = Integer.parseInt(stk.nextToken()); // 구간 합  
		
		arr = new long[N+1];    // 1-indexed
		tree = new long[4 * N]; // 세그먼트 트리 
		
		for(int i = 1; i <= N; ++i) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
		init(1, 1, N); // 트리 초기화
		
		StringBuilder sb = new StringBuilder();
		int Q = M+K; // 쿼리 개수 
		while (Q-- > 0) {
			stk = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(stk.nextToken());
			
			if( type == 1 ) { // 값 변경 
				int idx = Integer.parseInt(stk.nextToken());
				long val = Long.parseLong(stk.nextToken());
				long diff = val - arr[idx];
				arr[idx] = val;
				update(1, 1, N, idx, diff);
			} else { // 구간 합 
				int l = Integer.parseInt(stk.nextToken());
				int r = Integer.parseInt(stk.nextToken());
				sb.append(query(1, 1, N, l, r)).append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}
	
	// 트리 초기화 
	private static long init(int node, int start, int end) {
		//리프노드에 도달 시 
		if(start == end) return tree[node] = arr[start];
		
		// 이진 탐색 
		int mid = (start + end) / 2;
		//현재 노드의 값은 자식 노드 두개를 합친 값. 
		return tree[node] = init(node*2, start, mid) + init(node*2+1, mid+1, end);
	}
	
	// 구간 합 질의
	private static long query(int node, int start, int end, int l, int r) {
		if( r < start || end < l) return 0; // 물어본 구간에 속하지 않는다면 
		if( l <= start && end <= r) return tree[node];
		
		int mid = (start+end) / 2;
		return query(node*2, start, mid, l, r) 
			 + query(node*2+1, mid+1, end, l, r);
	}
	
	private static void update(int node, int start, int end, int idx, long diff) {
		if(idx < start || idx > end) return; // 범위 밖
		
		tree[node] += diff; // 노드 업데이트
		if(start == end) return; // 리프 노드라면 종료
		
		int mid = (start + end) / 2;
		update(node*2, start, mid, idx, diff);
		update(node*2+1, mid+1, end, idx, diff);
	}
}

