import java.io.*;
import java.util.*;

public class Main {
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		
		int n = Integer.parseInt(str[0]);
		int r = Integer.parseInt(str[1]);
		int c = Integer.parseInt(str[2]);
		
		int num = 1 << n;
		recursion(0, num, r, c);
		
		System.out.print(answer);
	}
	
	private static void recursion(int nextSquare, int num, int r, int c)
	{
		if(num == 0) return;
		
		int half = num/2;
		answer += nextSquare;
		
		if(r < half && c < half) recursion(half*half*0, num/2, r, c);
		else if(r < half && c >= half) recursion(half*half*1, num/2, r, c-half);
		else if(r >= half && c < half) recursion(half*half*2, num/2, r-half, c);
		else if(r >= half && c >= half) recursion(half*half*3, num/2, r-half, c-half); 
	}
}
