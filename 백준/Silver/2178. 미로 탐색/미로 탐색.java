
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(stk.nextToken());
		int col = Integer.parseInt(stk.nextToken());
		boolean[][] visited = new boolean[row][col];
		
		int answer = 0;
		
		for(int i = 0; i < row; ++i)
		{
			String strCol = br.readLine();
			for(int j = 0; j < col; ++j)
			{
				visited[i][j] = strCol.charAt(j) - '0' > 0 ? false : true;
			}
		}
		
		//상하좌우 
		int[] dr = { 1, -1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
				
		Queue<int[]> queue = new LinkedList<int[]>();
		
		queue.add(new int[] { 0,0 });
		answer++;
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			
			for(int i = 0; i < size; ++i)
			{
				int[] currentPos = queue.poll();

				if(currentPos[0] == row-1 && currentPos[1] == col-1)
				{
					System.out.println(answer);
					return;
				}
				
				if(visited[currentPos[0]][currentPos[1]]) continue;
				visited[currentPos[0]][currentPos[1]] = true;
				
				for(int j = 0; j < 4; ++j)
				{
					int nr = currentPos[0] + dr[j];
					int nc = currentPos[1] + dc[j];
					
					if(nr < 0 || nr >= row || nc < 0 || nc >= col) continue;
					if(visited[nr][nc]) continue;
					
					queue.add(new int[] {nr, nc});
				}
			}
			answer++;		
		}
		
	}
} 
