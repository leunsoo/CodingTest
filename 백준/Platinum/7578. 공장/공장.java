import java.io.*;
import java.util.*;

public class Main {
	private static int[] tree;
	private static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N  = Integer.parseInt(br.readLine());
		tree = new int[N+1];

        // A공장 기계들
		int[] A = new int[N];
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; ++i) {
			A[i] = Integer.parseInt(stk.nextToken());
		}
		
		// B공장 기계들 위치 매핑
		Map<Integer, Integer> BPos = new HashMap<>();
		stk = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; ++i) {
			int machine = Integer.parseInt(stk.nextToken());
			BPos.put(machine, i+1);
		}
		
		long inversion = 0;
		
		for(int i = 0; i < N; ++i) {
			int machine = A[i];
			int pos = BPos.get(machine);
			
			inversion += query(N) - query(pos);
			
			update(pos,1);
		}
		
		System.out.println(inversion);
	}
	
	private static void update(int target, int value) {
		for(int i = target; i <= N; i += i & (-i)) {
			tree[i] += value;
		}
	}
	
	private static int query(int start) {
		int sum = 0;
		for(int i = start; i > 0; i -= i & (-i)) {
			sum += tree[i];
		}
		
		return sum;
	}
}