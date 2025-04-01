import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	static long[] tree;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N+1];
		tree = new long[N*4];
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N ;++i) {
			arr[i] = Integer.parseInt(stk.nextToken());
		}
		
		init(1, 1, N);
		
		int M = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; ++i) {
			stk = new StringTokenizer(br.readLine());
			int order = Integer.parseInt(stk.nextToken());
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			
			if(order == 1) { // a를 b로 바꾼다
				int diff = b - arr[a];
				arr[a] = b;
				update(1, 1, N, a, diff);
			}
			else { // a~b에서 가장 작은 값을 출력한다.
				sb.append(query(1, 1, N, a, b)).append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}
	
	private static long init(int node, int start, int end) {
		if(start == end) return tree[node] = arr[start];
		
		int mid = (start + end)/2;
		return tree[node] = Math.min(init(node*2, start, mid), init(node*2+1, mid+1, end));
	}
	
	private static void update(int node, int start, int end, int idx, int diff) {
		if(idx < start || idx > end) return;
		
		if(start == idx && end == idx) {
			tree[node] = arr[idx];
			return;
		}
		
		int mid = ( start + end ) / 2;
		update(node*2, start, mid, idx, diff);
		update(node*2+1, mid+1, end, idx, diff);
		tree[node] = Math.min(tree[node*2], tree[node*2+1]);
	}
	
	private static long query(int node, int start, int end, int left, int right) 
	{
		if(left > end || right < start) return Long.MAX_VALUE;
		
		if(left <= start && end <= right) return tree[node];
		
		int mid = (start + end) / 2;
		return Math.min(query(node*2, start, mid, left, right), query(node*2+1, mid+1, end, left, right));
	}
}
