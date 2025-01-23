import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		int inputCnt = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<>();
		
		
		StringBuffer sb = new StringBuffer();
		int latestNum = 0;
		
		while(inputCnt-- > 0)
		{
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			String command = stk.nextToken();
			
			switch (command) {
			case "push":
				latestNum = Integer.parseInt(stk.nextToken());
				queue.add(latestNum);
				break;
			case "pop":
				if(queue.isEmpty())
				{
					sb.append("-1").append("\n");
				}
				else {
					sb.append(queue.poll()).append("\n");
				}
				break;
			case "size":
				sb.append(queue.size()).append("\n");
				break;
			case "empty":
				if(queue.isEmpty())
					sb.append("1").append("\n");
				else
					sb.append("0").append("\n");
				break;
			case "front":
				if(queue.isEmpty())
				{
					sb.append("-1").append("\n");
				}
				else {
					sb.append(queue.peek()).append("\n");
				}
			 	break;
			case "back":
				if(queue.isEmpty())
				{
					sb.append("-1").append("\n");
				}
				else {
					sb.append(latestNum).append("\n");
				}
			 	break;
			}
		}
		
		System.out.println(sb.toString());
	}
}