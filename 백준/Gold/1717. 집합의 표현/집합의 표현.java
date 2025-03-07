import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		
		arr = new int[n+1];
		
		for(int i = 0; i <= n; ++i) {
			arr[i] = i;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < m; ++i) {
			stk = new StringTokenizer(br.readLine());
			int oper = Integer.parseInt(stk.nextToken());
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			
			if(oper == 1) {
				if(findRoot(a) != findRoot(b)) {
					sb.append("NO").append("\n");
					continue;
				}

				sb.append("YES").append("\n"); 
			}
			else {
				union(a, b);
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	//현재 자신의 값이 자신과 같지 않다는 것은 부모가 있다는 것
	//해당 부모의 부모로 이동해서 루트까지 탐색
	//돌아오면서 거쳐간 부모들의 루트도 갱신(깊이 평탄화)
	private static int findRoot(int idx)
	{
		if(arr[idx] == idx) return idx;
		
		return arr[idx] = findRoot(arr[idx]);
	}
	
	// 합침 연산
	// 동일한 루트를 가지게 만든다. 
	private static void union(int a, int b) {
		int rootA = findRoot(a);
		int rootB = findRoot(b);

		arr[rootB] = rootA;
	}
}
