import java.io.*;
import java.util.*;

class Island {
	int x, y;
	
	public Island(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Edge implements Comparable<Edge> {
	int start, to;
	double dist;
	
	public Edge(int start, int to, double dist) {
		this.start = start;
		this.to = to;
		this.dist = dist;
	}
	
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return Double.compare(dist, o.dist);
	}
}

public class Solution {
	static ArrayList<Edge> lst;
	static int[] parents;
	static double answer;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= T; ++ tc)
		{
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(br.readLine()); // 섬의 개수
			
			Island[] islands = new Island[N]; // 섬
			lst = new ArrayList<>(); // 섬들간의 간선을 담을 리스트
			parents = new int[N]; // 유니온 파인드에 쓰일 배열
			answer = 0; 
			
			StringTokenizer stk = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; ++i) { // 섬의 x 좌표
				islands[i] = new Island(0, 0);
				parents[i] = i;
						
				islands[i].x = Integer.parseInt(stk.nextToken());
			}

			stk = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; ++i) { // 섬의 y 좌표
				islands[i].y = Integer.parseInt(stk.nextToken());
			}
			
			for(int i = 0; i < N-1; ++i) {
				for(int j = i+1; j < N; ++j) {
					lst.add(new Edge(i, j, Math.pow(Math.abs(islands[i].x - islands[j].x),2)+ Math.pow(Math.abs(islands[i].y - islands[j].y),2)));
				}
			}
			
			Collections.sort(lst);
			solution();
			
			double tax = Double.parseDouble(br.readLine()); // 세율
			sb.append(Math.round(answer * tax)).append("\n");
			
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	private static void solution() {
		int cnt = 0;
		
		for (Edge e : lst) {
			if(cnt == N-1) return; // 간선의 수는 N-1이어야 최소이다.
			
			if(union(e.start, e.to)) { // 사이클이 발생하지 않으면
				answer += e.dist;
				cnt++;
			}
		}
	}
	
	private static int find(int x) {
		if(parents[x] == x) return x;
		return parents[x] = find(parents[x]);
	}
	
	private static boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		if(pa == pb) return false; // 사이클
		
		parents[pa] = pb; // 합병
		return true;
	}
}
