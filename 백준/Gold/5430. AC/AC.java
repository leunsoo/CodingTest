
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		byte testCase = Byte.parseByte(br.readLine());
		
	    for(int i = 0; i < testCase; ++i)
		{
			String commands = br.readLine();
			int arrSize = Integer.parseInt(br.readLine());
			String str = br.readLine();
			String[] strArr = str.substring(1,str.length()-1).split(",");
			Deque<Integer> deque = new ArrayDeque<>();
			boolean isError = false;
			
			for(int j = 0; j < arrSize; ++j)
			{
				deque.add(Integer.parseInt(strArr[j]));
			}
			
			int commandsLength = commands.length();
			boolean isFirstOut = true;
			
			for(int j = 0; j < commandsLength; ++j)
			{
				char command = commands.charAt(j);
				
				if(command == 'D')
				{
					if(deque.isEmpty())
					{
						System.out.println("error");
						isError = true;
						break;
					}
					
					if(isFirstOut) {
						deque.pollFirst();
					}
					else {
						deque.pollLast();
					}
				}
				else {
					isFirstOut = !isFirstOut;
				}
			}
			
			if(!isError)
			{
				StringBuffer sb = new StringBuffer();
				sb.append("[");
				if(isFirstOut) //순서대로 출
				{
					while(!deque.isEmpty())
					{
						sb.append(deque.pollFirst()).append(",");
					}
				}
				else //역순으로 출력  
				{ 
					while(!deque.isEmpty())
					{
						sb.append(deque.pollLast()).append(",");
					}
				}

				if(sb.length() > 2)
					sb.deleteCharAt(sb.length()-1);
				
				sb.append("]");
				System.out.println(sb);
			}
		}
	}
}

