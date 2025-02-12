import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int M;
    static int[] nums; //출력을 위한 녀석
    static boolean[] visited; // 순회 패스
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		
		nums = new int[M];
		visited = new boolean[N + 1];
		recursive(0, 0, 0);
		
		bw.flush();
		bw.close();
	}
	
	//중복되는 수열을 여러 번 출력하면 안된다.
	//m = nums idx
	private static void recursive(int m, int cnt, int num) throws IOException
	{
		if(m == M ) {
			for (int i : nums) {
				bw.write(i+" ");
			}
			bw.write("\n");
			return;
		}
		
		for(int i = 1; i <= N; ++i )
		{
			if(visited[i] || num > i) continue;
			
			nums[m] = i;
			cnt += 1;
			recursive(m+1, cnt+1, i);
			cnt -= 1;
			
			if(cnt == 0) visited[i] = true;
		}
	}
}
