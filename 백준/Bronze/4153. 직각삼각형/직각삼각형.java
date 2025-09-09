import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[3];
		StringBuilder sb = new StringBuilder();
		while(true) {
			String str = br.readLine();
			if(str.equals("0 0 0")) {
				System.out.println(sb);
				return;
			}
			
			StringTokenizer stk = new StringTokenizer(str);
			for(int i = 0; i < 3; ++i) {
				arr[i] = Integer.parseInt(stk.nextToken());
			}
			
			Arrays.sort(arr);
			
			sb.append(arr[2]*arr[2] == (arr[1]*arr[1]+arr[0]*arr[0]) ? "right" : "wrong").append("\n");
		}
	}
}
