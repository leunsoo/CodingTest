import java.io.*;
import java.util.*;

public class Main {
	private static StringBuilder sb = new StringBuilder();
	private static ArrayList<Character> mo = new ArrayList<Character>();
	private static char[] arr;
	private static char[] temp;
	static int L;
	static int C;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] strs = br.readLine().split(" ");
		L = Integer.parseInt(strs[0]);
		C = Integer.parseInt(strs[1]);
		arr = new char[C];
		temp = new char[L];
		
		String check = "aeiou";
		
		String str = br.readLine();
		for(int i = 0; i < C; ++i) {
			char c = str.charAt(i*2);
			arr[i] = c;
			
			if(check.contains(Character.toString(c))) {
				mo.add(c);
			}
		}
		
		Arrays.sort(arr);
		Collections.sort(mo);
		
		dfs(0,0);
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush();
	}

	
	//C개 중에 L개 뽑기 오름차순, 중복 x 
	private static void dfs(int cnt, int idx) {
		if(cnt == L) {
			String str = "";
			int moCnt = 0;
			
			for (char c : temp) { // 모음체크
				for(int i = 0; i < mo.size(); ++i) {
					if(mo.get(i) == c ) moCnt++;
				}
				str += c;
			}
			
			//모음이 없거나 자음이 2개 미만이면
			if(moCnt == 0 || L - moCnt < 2) 
				return;
			
			sb.append(str).append("\n");
			return;
		}
		
		for(int i = 0; i < C; ++i) {
			if( i < idx) continue;
			
			temp[cnt] = arr[i];
			dfs(cnt+1, i+1);
		}
	}
}
