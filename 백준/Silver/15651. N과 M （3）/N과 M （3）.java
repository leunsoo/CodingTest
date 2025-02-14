import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[] nums;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		nums = new int[M];
		
		recursive(N, M, 0);
		
		bw.flush();
		bw.close();
	}
	
	private static void recursive(int n, int m, int cnt) throws IOException 
	{
		if(cnt == m)
		{
			for (int i : nums) {
				bw.write(i + " ");
			}
			bw.write("\n");
			return;
		}
			
		for(int i = 1; i <= n; ++i)
		{
			nums[cnt] = i;
			recursive(n, m, cnt+1);
		}
	}
}
