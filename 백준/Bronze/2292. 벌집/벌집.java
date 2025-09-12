import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int start = 1;
		int around = 6;
		int passed = 0;
		
		while (N > start) {
			start += around;
			around += 6;
			passed++;
		}
		
		System.out.println(++passed);
	}
}