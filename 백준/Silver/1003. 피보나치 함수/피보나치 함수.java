import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());

		int[][] arr = new int[41][2];
		arr[0] = new int[] { 1, 0 };
		arr[1] = new int[] { 0, 1 };
		arr[2] = new int[] { 1, 1 };

		for (int i = 3; i < 41; ++i) {
			arr[i] = new int[] { arr[i - 1][0] + arr[i - 2][0], arr[i - 1][1] + arr[i - 2][1] };
		}

		for (int i = 0; i < t; ++i) {
			int num = Integer.parseInt(br.readLine());
			bw.write(arr[num][0] + " " + arr[num][1] + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}