import java.io.*;
import java.util.Iterator;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		
		int multiple = A * B * C;
		int[] arr = new int[10];
		
		while (multiple  > 10) {
			arr[multiple%10]++;
			multiple /= 10;
		}
		
		arr[multiple]++;
		
		StringBuilder sb = new StringBuilder();
		for(int n : arr) {
			sb.append(n).append("\n");
		}
		
		System.out.println(sb);
	}
}
