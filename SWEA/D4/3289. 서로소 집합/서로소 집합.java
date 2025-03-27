import java.io.*;
import java.util.*;

public class Solution {
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
			
			int[] nums = new int[N+1];
			for(int i = 0; i <= N; ++i) {
				nums[i] = i;
			}
			
			//알고리즘 입력과 동시에
			for(int i = 0; i < M; ++i) {
				stk = new StringTokenizer(br.readLine());
				int order = Integer.parseInt(stk.nextToken());
				int a = Integer.parseInt(stk.nextToken());
				int b = Integer.parseInt(stk.nextToken());
				
				if(order == 1) { // find
					if(find(a,nums) == find(b, nums)) // 같은 집합에 속해있다면 
						sb.append(1); // 1출력
					else  // 아니라면
						sb.append(0); // 0출력
				}
				else { // union
					union(a, b, nums);
				}
			}
			
			sb.append("\n");
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	private static int find(int x, int[] parents)
	{
		if(parents[x] == x) return x; // 자기 자신이 부모일 경우
		return parents[x] = find(parents[x], parents); // 부모 찾기
	}
	
	private static void union(int a, int b, int[] nums) {
		int fa = find(a, nums);
		int fb = find(b, nums);
		
		if(fa != fb) { // 같은 집합으로 만들어주기
			nums[fb] =  fa;
		}
	}
}
