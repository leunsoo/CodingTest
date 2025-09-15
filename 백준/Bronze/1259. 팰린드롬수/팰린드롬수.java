import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		while (true) {
			String str = br.readLine();
			
			if(str.equals("0")) {
				System.out.println(sb);
				return;
			}
			
			String answer = "yes";
			for(int i = 0; i < str.length()/2; ++i) {
				if(str.charAt(i) != str.charAt(str.length()-i-1)) {
					answer = "no";
				}
			}
			
			sb.append(answer).append("\n");
		}
	}
}
