import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> primes = new ArrayList<>();
		
		boolean[] isPrime = new boolean[n+1];
		
		for(int i = 2; i < n+1; ++i)
		{
			isPrime[i] = true;
		}
		
		//소수 추출
		for(int i = 2; i*i <= n; ++i)
		{
			if(isPrime[i] == true)
			{
				for(int j = 2*i; j <= n; j += i)
				{
					isPrime[j] = false;
				}
			}
		}
		
		for(int i = 0; i < n+1; i++)
		{
			if(isPrime[i]) primes.add(i);
		}
		
		int size = primes.size();
		int sum = 0;
		int answer = 0;
		int min = 0;
		for(int i = 0; i < size; )
		{	
			if(sum == n)
			{
				answer++;

				sum -= primes.get(min);
				min++;
			}
			else if(sum > n)
			{
				sum -= primes.get(min);
				min++;
			}
			else if(sum < n)
			{
				sum += primes.get(i);
				++i;
			}
		}
		if(isPrime[n]) answer++;
		
		System.out.println(answer);
	}
}
