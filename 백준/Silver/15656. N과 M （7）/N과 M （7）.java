import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	
	static int[] arr;
	static int[] answerArr;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().trim().split(" ");
		N = Integer.parseInt(str[0]); 
		M = Integer.parseInt(str[1]);
		
		arr = new int[N];
		answerArr = new int[M];
		
		StringTokenizer stk = new StringTokenizer(br.readLine().trim());
		for(int i = 0; i < N; ++i)
		{
			arr[i] = Integer.parseInt(stk.nextToken());
		}
		
		Arrays.sort(arr);
		recursive(0);
		
		bw.flush();
		bw.close();
	}
	
	private static void recursive(int cnt) throws IOException
	{
		if(cnt == M)
		{
			for (int i : answerArr) {
				bw.write(i + " ");
			}
			bw.write("\n");
			return;
		}
		
		for(int i = 0; i < N; ++i)
		{	
			answerArr[cnt] = arr[i];
			recursive(cnt+1);
		}
	}
}

