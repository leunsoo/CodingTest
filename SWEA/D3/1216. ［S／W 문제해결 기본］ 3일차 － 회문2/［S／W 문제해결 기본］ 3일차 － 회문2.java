import java.io.*;
import java.util.*;

public class Solution {
	static String[] strArr = new String[100];
	static int max = 0;
	static final int MAX_LENGTH = 99;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; ++tc) {
			int n = Integer.parseInt(br.readLine()); 
			for (int i = 0; i < 100; ++i) {
				strArr[i] = br.readLine();
			}

			max = 0;
			for (int i = 0; i < 100; ++i) {
				for (int j = 0; j < 100; ++j) {
					palindromeRow(i, j);
					palindromeCol(i, j);
				}
			}
			
			System.out.println("#"+n+" "+max);
		}

	}

	private static void palindromeRow(int i, int j) {
		if(MAX_LENGTH - j < max) return;
		
		for(int x = MAX_LENGTH; x > j ; --x) // j 부터 length까지 구간 추출
		{
			if(x-j < max) return; // max값보다 작은 구간은 검사할 필요가 없음
			boolean flag = true;
			// 해당 구간이 회문검사
			for(int y = 0, half = (x-j)/2; y <= half; ++y) 
			{ 
				if(strArr[i].charAt(j+y) != strArr[i].charAt(x-y)) 
				{
					flag = false;
					break;
				}
				
			}
			
			int dist = x-j+1;
			//회문일경우 , 가장 큰 길이부터 탐색하므로 바로 리턴가능
			if(flag) {
				max = max < dist ? dist : max;
				return;
			}
		} 
	}

	private static void palindromeCol(int i, int j) {
		if(MAX_LENGTH - i < max) return;
		
		for(int x = MAX_LENGTH; x > i ; --x)
		{
			if(x-i < max) return;
			boolean flag = true;
			for(int y = 0, half = (x-i)/2; y <= half; ++y) 
			{ 
				if(strArr[i+y].charAt(j) != strArr[x-y].charAt(j)) 
				{
					flag = false;
					break;
				}
				
			}

			int dist = x-i+1;
			if(flag) {
				max = max < dist ? dist : max;
				return;
			}
		} 
	}
}
