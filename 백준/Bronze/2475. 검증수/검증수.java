import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		int res = 0;
		while (stk.hasMoreTokens()) {
			res += Math.pow((stk.nextToken().charAt(0) - '0'),2);
		}
		
		System.out.println(res%10);
	}
}
