import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		System.out.println(fibo(num));
	}
	
	//피보나치란 무엇인가
	//f(1) = 1,
	//f(2) = 1,
	//f(3) = f(2) + f(1)
	//f(n) = f(n-1) + f(n-2)
	public static int fibo(int num)
	{
		if( num == 0)
		{
			return 0;
		}
		else if( num <= 2)
		{
			return 1;
		}
		
		return fibo(num - 1) + fibo(num- 2);
	}
}
