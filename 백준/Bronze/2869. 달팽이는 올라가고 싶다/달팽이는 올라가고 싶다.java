import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(stk.nextToken());
		int B = Integer.parseInt(stk.nextToken());
		int V = Integer.parseInt(stk.nextToken())-A;
		
		int C = V-1 < 0 ? 0 : (V-1)/(A-B) +1;
		System.out.println(1+C);
	}
}
