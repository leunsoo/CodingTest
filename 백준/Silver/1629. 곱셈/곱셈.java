import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		long A = sc.nextInt();
		long B = sc.nextInt();
		long C = sc.nextInt();
		
		System.out.println(recursive(A, B, C));
	}
	
	private static long recursive(long a, long b, long c) {
		if(b==1) return a%c;
		long r = recursive(a, b/2, c);
		r = r*r%c;
		if(b%2 == 0) return r;
		return r*a%c;
	}
}
