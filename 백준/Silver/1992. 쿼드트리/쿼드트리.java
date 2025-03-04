import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static Character[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new Character[N][N];
		
		for(int i = 0; i < N; ++i) {
			String str = br.readLine();
			for(int j = 0; j < N; ++j) {
				map[i][j] = str.charAt(j);
			}
		}
		
		if(N == 1) {
			System.out.println(map[0][0]);
			return;
		}
		
		System.out.println(dfs(0, 0, N));
		
	}
	
	private static String dfs(int i, int j, int size) {
		if(size == 1) {
			return map[i][j].toString();
		}
		
		String str = dfs(i, j, size/2) +  dfs(i, j+size/2, size/2) + dfs(i+size/2, j, size/2) + dfs(i+size/2, j+size/2, size/2);
		
		if(str.equals("0000")) 
			return "0";
		else if(str.equals("1111"))
			return "1";
		else {
			return "("+str+")";
		}
	}
}
