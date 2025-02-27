import java.io.*;
import java.util.*;
public class Main {
	static ArrayList<Integer>[] map;
	static boolean[] visited;
	static boolean isClear;
			
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer strs = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(strs.nextToken()); // 사람의 수
		int M = Integer.parseInt(strs.nextToken()); // 친구 관계의 수
		
		map = new ArrayList[N];
		
		for(int i = 0; i < N; ++i) {
			map[i] = new ArrayList<Integer>();
		}
		visited = new boolean[N];
		
		//맵 그리기
		for(int i = 0; i < M; ++i) {
			strs = new StringTokenizer(br.readLine());
			int p1 = Integer.parseInt(strs.nextToken()); 
			int p2 = Integer.parseInt(strs.nextToken());
			map[p1].add(p2);
			map[p2].add(p1);
		}
		
		for(int i = 0; i < N; ++i) {
			dfs(1, i);
			if(isClear) break;
		}
		
		System.out.println(isClear ? 1 : 0);
	}
	
	private static void dfs(int cnt, int node) {
		if(cnt == 5) {
			isClear = true;
			return;
		}
		visited[node] = true;
		
		for(int i = 0; i < map[node].size(); ++i) {
			if(visited[map[node].get(i)]) continue;
			
			dfs(cnt+1, map[node].get(i));
		}
		visited[node] = false;
	}
}
