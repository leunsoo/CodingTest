import java.io.*;
import java.util.*;

public class Solution {
	static int[] ky = new int[9]; // 규영이 숫자
	static int[] iy; // 인영이 숫자

	static int kyWin; // 규영이 승
	static int iyWin; // 인영이 승

	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; ++tc) {
			visited = new boolean[9];
			kyWin = 0;
			iyWin = 0;
			
			ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18));

			StringTokenizer stk = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; ++i) {
				int num =  Integer.parseInt(stk.nextToken());
				ky[i] = num;
				nums.remove((Object)num);
			}
			
			iy = nums.stream().mapToInt(Integer::intValue).toArray();

			dfs(0, 0, 0);
			sb.append("#").append(tc).append(" ").append(kyWin).append(" ").append(iyWin).append("\n");
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void dfs(int cnt, int kyScore, int iyScore) {
		if (cnt == 9) {
			if(kyScore > iyScore) kyWin++;
			if(iyScore > kyScore) iyWin++;
			return;
		}

		for (int i = 0; i < 9; ++i) {
			if(visited[i]) continue;
			
			visited[i] = true;
			if(ky[cnt] > iy[i]) 
				dfs(cnt+1, kyScore + ky[cnt] + iy[i], iyScore);
			if(iy[i] > ky[cnt])
				dfs(cnt+1, kyScore, iyScore + ky[cnt] + iy[i]);
			
			visited[i] = false;
		}
	}
}