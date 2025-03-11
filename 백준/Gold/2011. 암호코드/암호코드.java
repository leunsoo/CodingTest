import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 String str = "0"+ br.readLine();
		 
		 if(str.charAt(1) == '0') { // 해석할 수 없는 경우 , 음수 안됨 
			 System.out.println(0);
			 return;
		 }
		 
		 int[] dp = new int[str.length()]; // i번째까지의 문자에에서 나올 수 있는 해석의 가짓수 
		 
		 dp[0] = dp[1] = 1; // 첫글자에 올 수 있는 해석의 가짓수는 단 한개뿐 
		 
		 for(int i = 2; i < str.length(); ++i) {
			 int ex = str.charAt(i-1) - '0';
			 int curr = str.charAt(i) - '0';
			 
			 
			 //해석할 수 없는 경우 00, 30~90 
			 if((curr == 0 && ex == 0) || (curr == 0 && ex >= 3) ) {
				 System.out.println(0);
				 return;
			 }
			 
			 if(curr != 0) 
				 dp[i] += dp[i-1];
			 
			 int two = ex*10 + curr;
			 if( two >= 10 && two <= 26)
				 dp[i] += dp[i-2];
			 
			 dp[i]%=1000000;
		 }
		 
		 System.out.println(dp[str.length()-1]);
	}
}
