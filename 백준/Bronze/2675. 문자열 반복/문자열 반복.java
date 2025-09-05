import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			String[] strs = br.readLine().split(" ");
			int R = Integer.parseInt(strs[0]);
			int length = strs[1].length();
			
			for(int i = 0; i < length; ++i) {
				for(int r = 0; r < R; ++r) {
					sb.append(strs[1].charAt(i));
				}
			}	
			
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
