import java.io.*;
import java.util.*;

public class Solution {

	static int[][] foods;
	static int foodCnt;
	static int half;
	static int min;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; ++tc) {
			foodCnt = Integer.parseInt(br.readLine());
			half = foodCnt / 2;
			min = Integer.MAX_VALUE;

			foods = new int[foodCnt][foodCnt];
			visited = new boolean[foodCnt];

			for (int i = 0; i < foodCnt; ++i) {
				StringTokenizer stk = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < foodCnt; ++j) {
					foods[i][j] = Integer.parseInt(stk.nextToken());
				}
			}
			
			makeFood(0,0);
			
			System.out.println("#" + tc + " " + min);

		}
	}

	//m 개 중 n개 뽑기 
	//a 음식만 다 뽑으면 b 음식은 나머지것들을 더하면 된다 .
	static void makeFood(int cnt, int idx) {
		if (cnt == half)
		{
			int asum = 0;
			int bsum = 0;
			
			for(int i = 0; i < foodCnt; ++i)
			{
				for(int j = 0; j < foodCnt; ++j)
				{
					if(i == j) continue;
					
					if(visited[i] && visited[j]) asum += foods[i][j];
					else if(!visited[i] && !visited[j]) bsum += foods[i][j];
				}
			}
			
			int num = Math.abs(asum - bsum);
			if(min > num) min = num ;
		
			return;
		}
		
		for(int i = idx; i < foodCnt; ++i)
		{
			visited[i] = true;
			makeFood(cnt+1, i+1);
			visited[i] = false;
		}
	}
}
