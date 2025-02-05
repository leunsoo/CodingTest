

import java.io.*;
import java.util.*;

public class Main {
	private static int count = 0;
	private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Hanoi(n, 1, 2, 3);
		
		sb.insert(0, count);
		System.out.println(sb.toString());
	}
	
	public static void Hanoi(int current, int start, int path, int target)
	{
		//다 옮겼다!
		if(current == 0) {
			return;
		}	
		
		count++;
		Hanoi(current-1, start, target, path);
		sb.append("\n").append(start).append(" ").append(target);
		Hanoi(current-1, path, start, target);
	}
}

