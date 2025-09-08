import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().trim();
		String s1 = "1 2 3 4 5 6 7 8";
		String s2 = "8 7 6 5 4 3 2 1";
		
		if(s1.equals(str)) {
			System.out.println("ascending");
		}
		else if(s2.equals(str))
		{
			System.out.println("descending");
		}
		else {
			System.out.println("mixed");
		}
		
	}
}
