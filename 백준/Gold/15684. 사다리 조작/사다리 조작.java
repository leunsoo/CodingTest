import java.io.*;
import java.util.*;
public class Main {
    static int N, M, H;
    static boolean[][] ladder;
    static boolean found = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        H = Integer.parseInt(stk.nextToken());

        ladder = new boolean[H + 1][N + 1];

        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            ladder[a][b] = true;
        }

        for (int limit = 0; limit <= 3; limit++) {
            dfs(0, 1, 1, limit);
            if (found) {
                System.out.println(limit);
                return;
            }
        }

        System.out.println(-1);
    }

    static void dfs(int cnt, int row, int col, int limit) {
        if (found) return;
        if (cnt == limit) {
            if (check()) {
                found = true;
            }
            return;
        }

        for (int i = row; i <= H; i++) {
            int jStart = (i == row) ? col : 1;
            for (int j = jStart; j < N; j++) {
                if (ladder[i][j] || ladder[i][j - 1] || ladder[i][j + 1]) continue;

                ladder[i][j] = true;
                dfs(cnt + 1, i, j + 2, limit); // 다다음으로 건너뛰기
                ladder[i][j] = false;
            }
        }
    }

    //사다리 체크 함수
    private static boolean check() 
    {
    	for(int i = 1; i <= N; ++i) {
    		int curr = i;
    		for(int h = 1; h <= H; ++h) {
    			if(ladder[h][curr]) 
    				curr++;
    			else if(ladder[h][curr-1]) {
    				curr--;
    			}
    		}
    		
    		if(i != curr) {
    			return false;
    		}
    	}
    	
    	return true;
    }
}
