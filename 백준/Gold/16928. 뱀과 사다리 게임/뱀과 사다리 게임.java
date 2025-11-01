import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken()); 
        
        int[] board = new int[101];
        for (int i = 1; i <= 100; i++) {
            board[i] = i; 
        }
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x] = y;
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            board[u] = v; 
        }
        
        System.out.println(bfs(board));
    }
    
    static int bfs(int[] board) {
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[101]; 
        Arrays.fill(visited, -1);
        
        queue.offer(1);
        visited[1] = 0;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            if (current == 100) {
                return visited[100];
            }
            
            for (int dice = 1; dice <= 6; dice++) {
                int next = current + dice;
                
                if (next > 100) {
                    continue;
                }
                
                next = board[next];
                
                if (visited[next] == -1) {
                    visited[next] = visited[current] + 1;
                    queue.offer(next);
                }
            }
        }
        
        return -1;
    }
}