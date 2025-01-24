import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int caseNum = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		
		StringBuilder sb = new StringBuilder();
		
		int num = 0;
		
		for(int i = 0; i < caseNum; ++i)
		{
			int compNum = Integer.parseInt(br.readLine());
			
			while (true) 
			{	
				if(stack.isEmpty() || stack.peek() < compNum) //스택 최상단이 비교대상군보다 작다면 값 넣어주기
				{
					stack.push(++num);
					sb.append("+").append("\n");
				}
				else if(stack.peek() == compNum) //스택 최상단과 비교대상군이 같다면 스택에 값 빼주기
				{
					stack.pop();
					sb.append("-").append("\n");
					break;
				}
				else // 스택 최상단이 비교대상군보다 크다면 끝
				{
					System.out.print("NO");
					return;
				}
			}
		}
		System.out.print(sb.toString());
	}
}