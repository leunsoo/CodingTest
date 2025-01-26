
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int caseNum = Integer.parseInt(br.readLine());

		
		for(int i = 0; i < caseNum; ++i)
		{
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int arrSize = Integer.parseInt(stk.nextToken());
			int targetIdx = Integer.parseInt(stk.nextToken());
			int answer = 1;
			
			Integer[] intArr = new Integer[arrSize];
			Queue<Integer> queue = new LinkedList<>();
			
			stk = new StringTokenizer(br.readLine());
			for(int j = 0; j < arrSize; ++j)
			{
				int num = Integer.parseInt(stk.nextToken());
				intArr[j] = num;
				queue.add(num);
			}
			
			Arrays.sort(intArr,Collections.reverseOrder());
			
			int k = 0;
			while (true) {
				
				if(queue.peek() == intArr[k] && targetIdx == 0)
				{
					System.out.println(answer);
					break;
				}
				else if(queue.peek() == intArr[k])
				{
					k++;
					answer++;
					queue.poll();
				}
				else {
					int num = queue.poll();
					queue.add(num);
				}
				
				if(--targetIdx < 0) 
				{
					targetIdx = queue.size()-1;
				}
			}
		}
	}
}
