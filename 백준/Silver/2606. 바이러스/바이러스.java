
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cCnt = Integer.parseInt(br.readLine()) + 1;
		int nCnt = Integer.parseInt(br.readLine());
		boolean[] visited = new boolean[cCnt];
		ArrayList<Integer>[] intArr = new ArrayList[cCnt];
		
		for(int i = 0; i < cCnt; ++i)
		{
			intArr[i] = new ArrayList<>();
		}
		
		//그래프 생성 
		for(int i = 0; i < nCnt; ++i)
		{
			String[] str = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			intArr[a].add(b);
			intArr[b].add(a);
		}
		
		Stack<Integer> stk = new Stack<>();
		stk.push(1);
		visited[1] = true;
		
		int answer = 0;
		while (!stk.isEmpty()) {
			int curCom = stk.pop();
			
			for(int i = 0; i < intArr[curCom].size(); ++i)
			{
				int connectedCom = intArr[curCom].get(i);
				if(visited[connectedCom]) continue;
				visited[connectedCom] = true;
				stk.push(connectedCom);
				answer++;
			}
		}
		
		System.out.println(answer);
	}
}
