import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); 
		int M = Integer.parseInt(br.readLine());  
		String S = br.readLine();                 
		
		int answer = 0;
		
		for(int i = 0; i < M; i++) {
			if(S.charAt(i) == 'I') {
				int count = 0;  
				
				while(i + 1 < M && S.charAt(i + 1) == 'O' 
				      && i + 2 < M && S.charAt(i + 2) == 'I') {
					
					count++;  
					if(count == N) {
						answer++;
						count--;  
					}
					
					i += 2; 
				}
			}
		}
		
		System.out.println(answer);
	}
}