import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int K;
	static int[] arr;
	static boolean[] bitmasked;
	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken()); // 단어의 개수
		K = Integer.parseInt(stk.nextToken()); // 가르칠 글자 개수
		
		if(K < 5) { // anta - tica 조차 못만든다.
			System.out.println(0);
			return;
		}
		
		bitmasked = new boolean['z'-'a'+1];
		bitmasked['a'-'a'] = true;
		bitmasked['t'-'a'] = true;
		bitmasked['n'-'a'] = true;
		bitmasked['i'-'a'] = true;
		bitmasked['c'-'a'] = true;
		
		arr = new int[N];
		
		for(int i = 0; i < N; ++i) {
			String word = br.readLine();
			int mask = 0;
			for(int j = 0; j < word.length(); ++j) {
				mask |= ( 1 << (word.charAt(j)-'a'));
			}
			arr[i] = mask;
		}

		max = 0;
		dfs(K-5, 0, -1);
		System.out.println(max);
	}
	
	private static void dfs(int N, int cnt, int idx) {
		if(cnt == N) {
			int wordCnt = check();
			max = Math.max(max, wordCnt);
			return;
		}
		
		for(int i = idx+1; i < 26; ++i) {
			if(bitmasked[i]) continue;
			
			bitmasked[i] = true;
			dfs(N, cnt+1, i);
			bitmasked[i] = false;
		}
	}
	
	private static int check() {
		int mask = 0;
		for(int b = 0; b < bitmasked.length; ++b) {
			if(bitmasked[b]) mask |= (1 << b);
		}
		
		int cnt = 0;
		for(int i = 0; i < N; ++i) {
			if((mask & arr[i]) == arr[i]) cnt++;
		}
		
		return cnt;
	}
}
