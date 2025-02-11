import java.io.*;
import java.util.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();
	private static int num;
	private static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		num = Integer.parseInt(str[0]);
		cnt = Integer.parseInt(str[1]);
		boolean[] visited = new boolean[num+1];
		String[] strArr = new String[cnt];
		recursion(visited, strArr, 0);
		
		System.out.println(sb);
	}
	
	private static void recursion(boolean[] visited, String[] str, int idx)
	{
		if(idx == cnt)
		{
			for(int i = 0; i < cnt; ++i)
			{
				sb.append(str[i]);
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 1; i <= num; i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			str[idx] = i + " ";
			recursion(visited, str, idx+1);
			visited[i] = false;
		}
	}
}
