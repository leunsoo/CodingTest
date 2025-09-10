import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] sizes = new int[6];
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < 6; ++i) {
			sizes[i] = Integer.parseInt(stk.nextToken());
		}
		
		stk= new StringTokenizer(br.readLine());
		int T = Integer.parseInt(stk.nextToken());
		int P = Integer.parseInt(stk.nextToken());
		
		int ansT = 0;
		
		for(int i = 0; i < 6; ++i) {
			if(sizes[i] == 0) continue;
			ansT += (sizes[i]-1)/T+1;
		}
		
		
		System.out.println(ansT);
		System.out.println(N/P + " " + N%P);
	}
}
