import java.io.*;
import java.util.*;

public class Main {

	private static StringBuilder sb = new StringBuilder();
	private static boolean[] isPrimes = new boolean[1000001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		getPrimes();

		while (true) {
			int n = Integer.parseInt(br.readLine());

			if (n == 0)
				break;
			
			Goldbach(n);
		}
		
		System.out.println(sb);
	}

	private static void Goldbach(int n) {
		int front = 2;
		int back = n;
		
		while (true) {
			if(!isPrimes[front]) { front++; continue; }
			if(!isPrimes[back]) { back--; continue; }
			
			if (front + back > n) {
				back--;
			} 
			else if (front + back < n) {
				front++;
			}
			else if (front + back == n){ // front + back == n
				sb.append(n).append(" = ").append(front).append(" + ").append(back).append("\n");
				return;
			}
            else if (front == back) {
                break;
            }
		}

		sb.append("Goldbach's conjecture is wrong.").append("\n"); 
	}
	
	private static void getPrimes() {
		Arrays.fill(isPrimes, true);
		isPrimes[0] = isPrimes[1] = false;
		
		for(int i = 2; i*i <= 1000000; ++i)
		{
			if(isPrimes[i])
			{
				for(int j = i*2; j <= 1000000; j+=i)
				{
					isPrimes[j] = false;
				}
			}
		}
	}
}
