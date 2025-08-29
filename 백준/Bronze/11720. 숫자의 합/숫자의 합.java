import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		String str = br.readLine();
		int ans = 0;
		for(int i = 0; i < str.length(); ++i) {
			ans += str.charAt(i) - '0';
		}
		
		System.out.println(ans);
	}
}
