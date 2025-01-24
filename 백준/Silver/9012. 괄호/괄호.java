import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int caseNum = Integer.parseInt(br.readLine());
		
		
		for(int i = 0; i < caseNum; ++i)
		{
			Stack<Character> stack = new Stack<>();
			String str = br.readLine();
			String answer = "YES";
			int strLength = str.length();
			
			for(int j = 0; j < strLength; ++j)
			{
				if(str.charAt(j) == ')')
				{
					if(stack.isEmpty())
					{
						answer = "NO"; 
						break;
					}
					else 
					{
						stack.pop();
					}
				}
				else {
					stack.push('(');
				}
			}
			
			if(!stack.isEmpty()) answer = "NO";
			
			System.out.println(answer);
		}
	}
}