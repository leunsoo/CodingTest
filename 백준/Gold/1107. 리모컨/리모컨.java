import java.io.*;
import java.util.*;

public class Main {
	private static int min; // 답
	private static int target; // 목표 채널 
	private static ArrayList<Integer> nums; // 입력 가능한 버튼

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		target = sc.nextInt();

		if (target == 100) {
			System.out.println(0);
			return;
		}
		
		nums = new ArrayList<Integer>();
		
		for(int i = 0; i < 10; ++i) {
			nums.add(i);
		}

		int M = sc.nextInt();
		for (int i = 0; i < M; ++i) {
			nums.remove((Object)sc.nextInt());
		}
		min = Math.abs(target - 100);

		for (int i = 0; i < nums.size(); ++i) {
			dfs(1, nums.get(i));
		}
		System.out.println(min);
	}

	private static void dfs(int cnt, int num) {
		if(cnt == 7) {
			return;
		}
		
		int calc = Math.abs(target - num);
		calc += cnt;
		if (min > calc)
			min = calc;

		
		for (int i = 0; i < nums.size(); ++i) {

			dfs(cnt + 1, num * 10 + nums.get(i));
		}
	}
}
