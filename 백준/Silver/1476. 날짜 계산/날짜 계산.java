import java.io.*;
import java.util.*;
public class Main {
	private static int E;
	private static int S;
	private static int M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		E = Integer.parseInt(strs[0]);
		S = Integer.parseInt(strs[1]);
		M = Integer.parseInt(strs[2]);
		
		System.out.println(recursive(0, 0, 0, 0));
	}
	
	private static int recursive(int e, int s, int m, int cnt) {
		if(e == 16) e = 1;
		if(s == 29) s = 1;
		if(m == 20) m = 1;
		
		if(e == E && s == S && m == M) 
		{
			return cnt;
		}
		
		return recursive(e+1, s+1, m+1, cnt+1);
	}
}
