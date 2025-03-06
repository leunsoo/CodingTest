import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; ++i) {
			for(int j = 1; j <= N; ++j) {
				sb.append(dfs(i, j, N));
			}
			sb.append("\n");
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	private static char dfs(int i, int j, int N) {
		if(N == 1) return '*';
		
		int start = N/3;
		int end = N - N/3;
		
		if(i > start && i <= end && j > start && j <= end)
			return ' ';
		
		if(i <= start && j <= start) {
			return dfs(i, j, N/3);
		}
		else if(i <= start && j > start && j <= end) {
			return dfs(i, j-start, N/3);
		}
		else if(i <= start && j > end) {
			return dfs(i, j-end, N/3);
		}
		else if(i > start && i <= end && j <= start) {
			return dfs(i-start, j, N/3);
		}
		else if(i > start && i <= end && j > end) {
			return dfs(i-start, j-end, N/3);
		}
		else if(i > end && j <= start) {
			return dfs(i-end, j, N/3);
		}
		else if(i > end &&  j > start && j <= end) {
			return dfs(i-end, j-start, N/3);
		}
		else {
			return dfs(i-end, j-end, N/3);
		}	
	}
}
