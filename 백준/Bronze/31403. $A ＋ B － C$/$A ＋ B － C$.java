import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String m = br.readLine();
		String e = br.readLine();
		
		
		System.out.println(Integer.parseInt(s)+Integer.parseInt(m)-Integer.parseInt(e));
		System.out.println(Integer.parseInt(s+m)-Integer.parseInt(e));
	}
}
