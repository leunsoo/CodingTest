import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		int inputCnt = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new LinkedList<>();
		
		
		StringBuffer sb = new StringBuffer();
		
		while(inputCnt-- > 0)
		{
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			String command = stk.nextToken();
			
			switch (command) {
			case "push_front":
				deque.addFirst(Integer.parseInt(stk.nextToken()));
				break;
			case "push_back":
				deque.addLast(Integer.parseInt(stk.nextToken()));
				break;
			case "pop_front":
				if(deque.isEmpty())
					sb.append("-1").append("\n");
				else
					sb.append(deque.pollFirst()).append("\n");
				break;
			case "pop_back":
				if(deque.isEmpty())
					sb.append("-1").append("\n");
				else
					sb.append(deque.pollLast()).append("\n");
				break;
			case "size":
				sb.append(deque.size()).append("\n");
				break;
			case "empty":
				if(deque.isEmpty())
					sb.append("1").append("\n");
				else
					sb.append("0").append("\n");
				break;
			case "front":
				if(deque.isEmpty())
				{
					sb.append("-1").append("\n");
				}
				else {
					sb.append(deque.peekFirst()).append("\n");
				}
			 	break;
			case "back":
				if(deque.isEmpty())
				{
					sb.append("-1").append("\n");
				}
				else {
					sb.append(deque.peekLast()).append("\n");
				}
			 	break;
			}
		}
		
		System.out.println(sb.toString());
	}
}