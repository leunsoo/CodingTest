import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String brreadLine = br.readLine();
		
		if(brreadLine.equals(" ")) {
			System.out.println(0);
			return;
		}
		System.out.println(brreadLine.trim().split(" ").length);
	}
}
