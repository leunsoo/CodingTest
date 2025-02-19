import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int[] arr;
	static int arrSize;
	
	static int[] temp;
	static final int LOTTO_CNT= 6;
	public static void main(String[] args) throws IOException {
		while (true) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			Integer cnt = Integer.parseInt(stk.nextToken());
			if(cnt == 0) break;
			
			arr = new int[cnt];
			temp = new int[LOTTO_CNT];
			
			for(int i = 0; i < cnt; ++i) {
				arr[i] = Integer.parseInt(stk.nextToken());
			}
			
			makeLottoNums(0, 0);
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
	
	private static void makeLottoNums(int cnt, int idx) throws IOException {
		if(cnt == LOTTO_CNT) {
			for (int i : temp) {
				bw.write(i + " ");
			}
			bw.write("\n");
			return;
		}
		
		for(int i = 0; i < arr.length; ++i) {
			if(i < idx) continue;
			
			temp[cnt] = arr[i];
			
			makeLottoNums(cnt+1, i+1);
		}
	}
}
