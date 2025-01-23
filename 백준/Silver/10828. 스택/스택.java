import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		int inputCnt = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		
		
		StringBuffer sb = new StringBuffer();
		while(inputCnt-- > 0)
		{
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			String command = stk.nextToken();
			
			switch (command) {
			case "push":
				stack.push(Integer.parseInt(stk.nextToken()));
				break;
			case "pop":
				if(stack.isEmpty())
				{
					sb.append("-1").append("\n");
				}
				else {
					sb.append(stack.pop()).append("\n");
				}
				break;
			case "size":
				sb.append(stack.size()).append("\n");
				break;
			case "empty":
				if(stack.isEmpty())
					sb.append("1").append("\n");
				else
					sb.append("0").append("\n");
				break;
			case "top":
				if(stack.isEmpty())
				{
					sb.append("-1").append("\n");
				}
				else {
					sb.append(stack.peek()).append("\n");
				}
			 	break;
			}
		}
		
		System.out.println(sb.toString());
	}
}