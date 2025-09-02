import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		while (tc-- > 0) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(stk.nextToken());
			int w = Integer.parseInt(stk.nextToken());
			int n = Integer.parseInt(stk.nextToken());
			n--;
			int f = (n%h)+1;
			int e = (n/h)+1;
			
			sb.append(f);
			if(e < 10) sb.append('0');
			sb.append(e).append("\n");
		}
		
		System.out.println(sb);
	}
}
