import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		int length = str.length();
		int N = Integer.parseInt(str);
		
		int num = 1;
		for(int i = 1; i < length; ++i) {
			num *= 10;
		}
		
		int answer = 0;
		while (num > 0) {
			int diff = N - num;
			diff++;
			answer += diff * length;
			N -= diff;
			length--;
			num /= 10;
		}
		
		System.out.println(answer);
	}
}