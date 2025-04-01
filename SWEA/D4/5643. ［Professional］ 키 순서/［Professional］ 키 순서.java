import java.io.*;
import java.util.*;

class Student {
	ArrayDeque<Integer> higher; // 자기보다 키 큰 사람 
	ArrayDeque<Integer> smaller; // 자기보다 키 작은 사람 
	
	Student() {
		higher = new ArrayDeque<>();
		smaller = new ArrayDeque<>();
	}
}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= T; ++tc) {
			sb.append("#").append(tc).append(" ");
			
			int N = Integer.parseInt(br.readLine()); // 학생의 수 
			int M = Integer.parseInt(br.readLine()); // 비교 수
			
			Student[] students = new Student[N+1];
			
			for(int i = 1; i <= N; ++i) {
				students[i] = new Student();
			}
			
			for(int i = 0; i < M; ++i) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(stk.nextToken());
				int b = Integer.parseInt(stk.nextToken());

				students[a].higher.add(b);
				students[b].smaller.add(a);
			}
			
			int ans = 0;
			for(int i = 1; i <= N; ++i) {
				if(N-1 == checkHigh(students, i, N) + checkSmaller(students, i, N)) ans++;
			}
			
			sb.append(ans).append("\n");
		}	
		
		System.out.println(sb.toString());
	}
	
	private static int checkHigh(Student[] students,int start, int N) {
		
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.add(start);
		
		boolean[] visited = new boolean[N+1];
		visited[start] = true;
		
		int cnt = 0;
		
		while (!queue.isEmpty()) {
			int curr = queue.poll();
			
			for (int student : students[curr].higher) {
				if(visited[student]) continue;
				
				cnt++;
				visited[student] = true;
				queue.add(student);
			}
		}
		
		return cnt;
	}
	
	private static int checkSmaller(Student[] students,int start, int N) {
		
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.add(start);
		
		boolean[] visited = new boolean[N+1];
		visited[start] = true;
		
		int cnt = 0;
		
		while (!queue.isEmpty()) {
			int curr = queue.poll();

			for (int student : students[curr].smaller) {
				if(visited[student]) continue;
				
				cnt++;
				visited[student] = true;
				queue.add(student);
			}
		}
		
		return cnt;
	}
}
