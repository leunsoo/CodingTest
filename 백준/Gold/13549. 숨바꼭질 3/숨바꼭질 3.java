import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int max = 100000;

		int N = sc.nextInt();
		int K = sc.nextInt();

		Queue<int[]> queue = new ArrayDeque<int[]>();
		boolean[] visited = new boolean[max+1];

		queue.add(new int[] { N, 0 });
		visited[N] = true;
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			int x = curr[0];
			int time = curr[1];
			
			if (x == K) {
				System.out.println(time);
				return;
			}

			//순간이동을 하는 경우에는 0초 후에 2*X의 위치로 이동하게 된다.
			if (x*2 <= max && !visited[x * 2] && x != 0 && x < K) {
				visited[x * 2] = true;
				queue.add(new int[] { x * 2, time });
			}
			//수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 
			if (x > 0 &&!visited[x - 1]) {
				visited[x - 1] = true;
				queue.add(new int[] { x - 1, time + 1 });
			}
			if (x < max && x < K && !visited[x + 1]) {
				visited[x + 1] = true;
				queue.add(new int[] { x + 1, time + 1 });
			}
		}
	}
}
