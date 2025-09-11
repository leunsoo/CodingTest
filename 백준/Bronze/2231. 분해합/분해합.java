import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int M = 1;
		
		while (true) {
			int tmp = M;
			int constructor = M;
			
			while (tmp > 0) {
				constructor += tmp%10;
				tmp /= 10;
			}
			
			if(constructor == N) {
				System.out.println(M);
				return;
			}
			if(constructor > 1000000) {
				System.out.println(0);
				return;
			}

			M++;
		}
	}
}
