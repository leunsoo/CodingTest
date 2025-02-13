import java.io.*;import java.security.spec.ECField;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String[] str = br.readLine().split(" ");
    	
    	int row = Integer.parseInt(str[0]);
    	int col = Integer.parseInt(str[1]);
    	int rectCnt = Integer.parseInt(str[2]);
    	int[][] paper = new int[row][col];
    	
    	//모눈종이 그리기
    	for(int i = 0; i < rectCnt; ++i)
    	{
    		str = br.readLine().split(" ");
    		
    		int ldx = Integer.parseInt(str[0]);
    		int ldy = Integer.parseInt(str[1]);
    		
    		int rux = Integer.parseInt(str[2]);
    		int ruy = Integer.parseInt(str[3]);
    		
    		//색칠
    		for(int j = ldx; j < rux; ++j) //컬럼
    		{
    			for(int k = row-ruy; k < row - ldy; ++k) //로우
    			{
    				paper[k][j] = 1;
    			}
    		}
    	}
    	
    	//상하좌우
    	int[] dr = { -1, 1, 0, 0 };
    	int[] dc = { 0, 0, -1, 1 };
    	
    	ArrayList<Integer> rects = new ArrayList<Integer>();
    	for(int i = 0; i < row; ++i)
    	{
    		for(int j = 0; j < col; ++j) {
    			if(paper[i][j] == 1) continue;
    			
    			int cnt = 1;
    			Queue<int[]> q = new ArrayDeque<int[]>();
    			q.add(new int[] { i, j });
    			while (!q.isEmpty()) {
					int[] point = q.poll();
					paper[point[0]][point[1]] = 1;
					
					for(int dir = 0; dir < 4; ++dir)
					{
						int nr = point[0] + dr[dir];
						int nc = point[1] + dc[dir];
						
						if(nr < 0 || nr >= row || nc < 0 || nc >= col) continue;
						if(paper[nr][nc] == 1) continue;
						
						q.add(new int[] { nr, nc });
						paper[nr][nc] = 1;
						cnt++;
					}
				}
    			
    			rects.add(cnt);
    		}
    	}
    	
    	Collections.sort(rects);
    	
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	bw.write(rects.size() + "\n");
    	for (int rectsize : rects) {
			bw.write(rectsize + " ");
		}
    	bw.flush();
    	bw.close();
    }
}