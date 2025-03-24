import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> compare = new Stack<>();
		int[] arr = new int[N];
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; ++i) {
			stack.add(Integer.parseInt(stk.nextToken()));
		}
		
		int idx = N-1;
		
		while (!stack.isEmpty()) {
			// compare가 비었다면 현재 값이 가장 큰 것
			if(compare.isEmpty()) {
				compare.push(stack.pop());
				arr[idx--] = -1;
			}
			else {
				if(compare.peek() > stack.peek()) { // compare의 peek()이 현재보다 크다면
					// peek()값 출력 후 현재 값 넣기
					arr[idx--] = compare.peek();
					compare.push(stack.pop());
				}
				else // compare의 peek()이 현재보다 작거나 같다면 
				{
					// 큰 값을 만날때까지 pop
					compare.pop();
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; ++i) {
			sb.append(arr[i]).append(" ");
		}
		
		System.out.println(sb.toString());
	}
}
