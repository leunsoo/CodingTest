import java.io.*;
import java.util.*;

public class Main {
	static long[] minTree;
	static long[] maxTree;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; ++tc) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(stk.nextToken());
			int K = Integer.parseInt(stk.nextToken());

			arr = new int[N+1];
			minTree = new long[N * 4];
			maxTree = new long[N * 4];
			
			for(int i = 1; i <= N; ++i) 
			{
				arr[i] = i-1;
			}

			init_min(1, 1, N);
			init_max(1, 1, N);

			for (int i = 0; i < K; ++i) {
				stk = new StringTokenizer(br.readLine());
				int Q = Integer.parseInt(stk.nextToken());
				int A = Integer.parseInt(stk.nextToken()) + 1;
				int B = Integer.parseInt(stk.nextToken()) + 1;

				if (Q == 0) { // 교체
					update_min(1, 1, N, A, arr[B]);
					update_min(1, 1, N, B, arr[A]);
					
					update_max(1, 1, N, A, arr[B]);
					update_max(1, 1, N, B, arr[A]);
					
					int temp = arr[A];
					arr[A] = arr[B];
					arr[B] = temp;
				} 
				else { // 확인
					if (A - 1 == query_min(1, 1, N, A, B) && B - 1 == query_max(1, 1, N, A, B)) {
						sb.append("YES");
					} else {
						sb.append("NO");
					}

					sb.append("\n");
				}
			}
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

	private static long init_min(int node, int start, int end) {
		if (start == end) {
			return minTree[node] = arr[start];
		}

		int mid = (start + end) / 2;
		return minTree[node] = Math.min(init_min( node * 2, start, mid), init_min( node * 2 + 1, mid + 1, end));
	}

	private static long init_max(int node, int start, int end) {
		if (start == end) {
			return maxTree[node] = arr[start];
		}

		int mid = (start + end) / 2;
		return maxTree[node] = Math.max(init_max( node * 2, start, mid), init_max( node * 2 + 1, mid + 1, end));
	}

	private static void update_min(int node, int start, int end, int idx, int val) {
		if(start > idx || end < idx) return ;
		if(start == end) 
		{
			minTree[node] = val;
			return;
		};
		
		int mid = (start+end)/2;
		update_min(node*2, start, mid, idx,  val);
		update_min(node*2+1, mid+1, end, idx,  val);
		minTree[node] = Math.min(minTree[node*2], minTree[node*2+1]);
	}

	private static void update_max(int node, int start, int end, int idx, int val) {
		if(start > idx || end < idx) return ;
		if(start == end) 
		{
			maxTree[node] = val;
			return;
		};
		
		int mid = (start+end)/2;
		update_max(node*2, start, mid, idx,  val);
		update_max(node*2+1, mid+1, end, idx,  val);
		maxTree[node] = Math.max(maxTree[node*2], maxTree[node*2+1]);
	}

	private static long query_min(int node, int start, int end, int left, int right) {
		if(left > end || start > right) return Long.MAX_VALUE;
		if(left <= start && end <= right) return minTree[node];
		
		int mid = (start+end)/2;
		return Math.min(query_min(node*2, start, mid, left, right), query_min(node*2+1, mid+1, end, left, right));
	}
	
	private static long query_max( int node, int start, int end, int left, int right) {
		if(left > end || start > right) return Long.MIN_VALUE;
		if(left <= start && end <= right) return maxTree[node];
		
		int mid = (start+end)/2;
		return Math.max(query_max(node*2, start, mid, left, right), query_max(node*2+1, mid+1, end, left, right));
	}
}
