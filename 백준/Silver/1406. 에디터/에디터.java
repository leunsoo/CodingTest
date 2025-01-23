import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder(br.readLine()); 
		
		int inputCnt = Integer.parseInt(br.readLine());
		
		int stringLength = answer.length();
		int pos = stringLength;
		
		while(inputCnt-- > 0)
		{
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			String command = stk.nextToken();
			
			switch (command) {
			case "L":
				if(--pos <= 0) pos = 0;
				break;
			case "D":
				if(++pos >= stringLength) pos = stringLength;
				break;
			case "B":
				if(pos == 0) continue;
				
				answer.deleteCharAt(pos-1);
				pos--;
				stringLength--;
				break;
			case "P":
				answer.insert(pos, stk.nextToken());
				pos++;
				stringLength++;
				break;
			}
		}
		
		System.out.println(answer);
	}
}