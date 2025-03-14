import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr1 = new int[N];
		int[] arr2 = new int[N];
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; ++i) {
			arr1[i] = Integer.parseInt(stk.nextToken());
		}
		
		stk = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; ++i) {
			arr2[i] = Integer.parseInt(stk.nextToken());
		}
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		int[] interval1 = new int[N*2];
		int[] interval2 = new int[N];
		
		interval1[0] = arr1[0] + 360000 - arr1[N-1];
		interval1[N] = interval1[0];
		interval2[0] = arr2[0] + 360000 - arr2[N-1]; 
		
		for(int i = 1; i < N; ++i) {
			interval1[i] = arr1[i] - arr1[i-1];
			interval1[N+i] = interval1[i];
			interval2[i] = arr2[i] - arr2[i-1];
		}
		
		
		if(KMP(interval1, interval2)) {
			System.out.println("possible");
		}
		else {
			System.out.println("impossible");
		}
	}
	
	public static boolean KMP(int[] arr, int[] pattern) {
		int[] lps = computeLPS(pattern);
		
		int j = 0;
		for(int i = 0; i < arr.length; ++i) {
			while (j > 0 && arr[i] != pattern[j]) {
				j = lps[j-1];
			}
			if(arr[i] == pattern[j])
				if(j == pattern.length-1) {
					return true;
				}
				else {
					j++;
				}
		}
		return false;
	}
	
	// LPS (Longest Prefix Suffix) 
	private static int[] computeLPS(int[] pattern) {
		int[] lps = new int[pattern.length];
		int j = 0; // 접두사 
		
		for(int i = 1; i < pattern.length; ++i) {
			while (j > 0 && pattern[i] != pattern[j]) {
				j = lps[j-1];
			}
			if(pattern[i] == pattern[j]) {
				j++;
				lps[i] = j;
			}
		}
		
		return lps;
	}
}
