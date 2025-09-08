import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().trim();
		
		StringBuilder sb = new StringBuilder();
		for(char i = 'a'; i <= 'z'; ++i) {
			sb.append(str.indexOf(i)).append(" ");
		}
		System.out.println(sb);
	}
}
