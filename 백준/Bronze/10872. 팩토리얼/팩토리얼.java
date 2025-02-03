
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		System.out.println(Fact(num));
	}
	
	private static int Fact(int num)
	{
		if(num <= 1) return 1;
		
		return num * Fact(num-1);
	}
}
