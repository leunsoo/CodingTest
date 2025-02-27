import java.io.*;
import java.util.*;
public class Main {
	static ArrayList<Integer>[] map;
	static boolean[] visited;
			
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		int N = Integer.parseInt(strs[0]); // 사람의 수
		int M = Integer.parseInt(strs[1]); // 친구 관계의 수
		
		map = new ArrayList[N];
		
		for(int i = 0; i < N; ++i) {
			map[i] = new ArrayList<Integer>();
		}
		visited = new boolean[N];
		
		//맵 그리기
		for(int i = 0; i < M; ++i) {
			strs = br.readLine().split(" ");
			int p1 = Integer.parseInt(strs[0]);
			int p2 = Integer.parseInt(strs[1]);
			map[p1].add(p2);
			map[p2].add(p1);
		}
		
		for(int i = 0; i < N; ++i) {
			dfs(0,i);	
		}
		
		System.out.println(0);
	}
	
	private static void dfs(int cnt, int node) {
		if(cnt == 5) {
			System.out.println(1);
			System.exit(0);
		}
		
		for(int i = 0; i < map[node].size(); ++i) {
			if(visited[map[node].get(i)]) continue;
			
			visited[map[node].get(i)] = true;
			dfs(cnt+1, map[node].get(i));
			visited[map[node].get(i)] = false;
		}
	}
}
