import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		boolean isEven = false;
		int sum = 0;
		for(int i = 0; i < str.length(); ++i) {
			char c = str.charAt(i);
			
			if(i%2 == 0) {
				
				if(c == '*') isEven = true;	
				else sum += c -'0';
			}
			else {
				if(c != '*') sum += (c - '0')*3;
			}
		}
		
		if(isEven) {
		    int result = (10 - sum%10) % 10;
		    System.out.println(result);
		}
		else {
			int num = sum%10;
			
			for(int i = 0; i <= 9; i++) {
				if((num + i*3)%10 == 0) {
					System.out.println(i);
					break;
				}
			}
		}
	}
}
