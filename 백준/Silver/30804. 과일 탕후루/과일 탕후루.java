import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());  
		int[] fruits = new int[N];                
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			fruits[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] count = new int[10];
		
		int left = 0;     
		int types = 0;    
		int maxLength = 0;
		
		for(int right = 0; right < N; right++) {
			int rightFruit = fruits[right];
		
			if(count[rightFruit] == 0) {
				types++;
			}
			count[rightFruit]++;
			
			while(types > 2) {
				int leftFruit = fruits[left];
				
				count[leftFruit]--;
				
				if(count[leftFruit] == 0) {
					types--;
				}
				
				left++; 
			}
			
			maxLength = Math.max(maxLength, right - left + 1);
		}
		
		System.out.println(maxLength);
	}
}