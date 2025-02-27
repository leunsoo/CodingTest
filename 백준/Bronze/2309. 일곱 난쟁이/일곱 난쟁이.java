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
		dfs(0, 0, origin, temp);
		
	}
	
	private static void dfs(int cnt, int idx, int[] origin, int[] temp) {
		if(cnt == 7) {
			StringBuilder sb = new StringBuilder();
			int sum = 0;
			for (int i : temp) {
				sum += i;
				sb.append(i).append("\n");
			}
			
			if(sum == 100) {
				System.out.println(sb.toString());
				System.exit(0);
			}
			
			return;
		}
		
		for(int i = 0; i < 9; ++i) {
			if(i < idx) continue;
			
			temp[cnt]= origin[i];
			dfs(cnt+1, i+1, origin, temp);
		}
	}
}
