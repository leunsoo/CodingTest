import java.io.*;
import java.util.*;

public class Main {
	static class State {
		ArrayList<Character> cmd;
		int num;
		
		public State(int num, ArrayList<Character> cmd) {
			this.num = num;
			
			this.cmd = new ArrayList<>();
			this.cmd.addAll(cmd);
		}
	}
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 0; tc < T; ++tc) {
			visited = new boolean[10000];
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(stk.nextToken());
			int end = Integer.parseInt(stk.nextToken());
			
			State ans = bfs(start, end);
			
			for(char c : ans.cmd) {
				sb.append(c);
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	private static State bfs(int start, int end) {
		Queue<State> queue = new ArrayDeque<>();
		queue.add(new State(start, new ArrayList<Character>()));
		visited[start] = true;
		
		while (true) {
			State currState = queue.poll();
			
			if(currState.num == end) {
				return currState;	
			}
			
			int D = D(currState.num);
			if(!visited[D]) {
				visited[D] = true;
				State newState = new State(D, currState.cmd);
				newState.cmd.add('D');
				queue.add(newState);
			}
			
			int S = S(currState.num);
			if(!visited[S]) {
				visited[S] = true;
				State newState = new State(S, currState.cmd);
				newState.cmd.add('S');
				queue.add(newState);
			}
			
			int L = L(currState.num);
			if(!visited[L]) {
				visited[L] = true;
				State newState = new State(L, currState.cmd);
				newState.cmd.add('L');
				queue.add(newState);
			}
			
			int R = R(currState.num);
			if(!visited[R]) {
				visited[R] = true;
				State newState = new State(R, currState.cmd);
				newState.cmd.add('R');
				queue.add(newState);
			}
		}
	}
	
	private static int D(int num) {
		return (num*2)%10000;
	}
	private static int S(int num) {
		num--;
		if(num < 0) num = 9999;
		return num;
	}
	private static int L(int num) {
		int l = (num%1000)*10;
		l += num/1000;
		return l;
	}
	private static int R(int num) {
		int r = num/10;
		r += (num%10)*1000;
		return r;
	}
}