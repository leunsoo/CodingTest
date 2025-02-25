import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] arr = new int[1001];
		
		arr[1] = 1;
		arr[2] = 3;
		
		for(int i = 3; i <= N; ++i) {
			arr[i] = (arr[i-1]+2*arr[i-2])%10007;
		}
		
		System.out.println(arr[N]);
	}
}
