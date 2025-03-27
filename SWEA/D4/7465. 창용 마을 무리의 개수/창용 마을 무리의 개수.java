import java.io.*;
import java.util.*;

public class Solution {
	static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= T; ++ tc)
		{
			sb.append("#").append(tc).append(" ");
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(stk.nextToken());
			int M = Integer.parseInt(stk.nextToken());
			
			parents = new int[N+1];
			for(int i = 1; i <= N; ++i) {
				parents[i] = i;
			}
			
			for(int i = 0; i < M; ++i) {
				stk = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(stk.nextToken());
				int b = Integer.parseInt(stk.nextToken());
				
				union(a, b);
			}

			//마지막 무리 통합
			for(int i = 1; i <= N; ++i ) {
				parents[i] = find(parents[i]);
			}
			
			//무리 개수를 확인하기 위한 set
			Set<Integer> set = new HashSet<>();
			for(int i = 1; i <= N; ++i ) {
				set.add(parents[i]);
			}
			
			sb.append(set.size()).append("\n");
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	private static int find(int x) {
		if(parents[x] == x) return x;
		return parents[x] = find(parents[x]);
	}
	
	private static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		if(pa != pb) {
			parents[pa] = pb;
		}
	}
}
