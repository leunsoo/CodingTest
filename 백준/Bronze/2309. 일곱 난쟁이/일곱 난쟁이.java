import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] origin = new int[9];
		int[] temp = new int[7];
		
		for(int i = 0; i < 9; ++i) {
			origin[i] = sc.nextInt();
		}
		
		Arrays.sort(origin);
		dfs(0, 0, origin, temp, 0);
		
	}
	
	private static void dfs(int cnt, int idx, int[] origin, int[] temp, int sum) {
		if(sum > 100) return;
		if(cnt == 7 && sum == 100) {
			for (int i : temp) {
				System.out.println(i);
			}
			System.exit(0);
		}
		if(cnt == 7) return;
		
		for(int i = 0; i < 9; ++i) {
			if(i < idx) continue;
			
			temp[cnt]= origin[i];
			dfs(cnt+1, i+1, origin, temp,sum+ temp[cnt]);
		}
	}
}
