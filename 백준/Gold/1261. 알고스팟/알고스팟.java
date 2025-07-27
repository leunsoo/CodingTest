import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int r, c, cost;

        public Node(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    static int N;
    static int M;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        M = Integer.parseInt(strs[0]);
        N = Integer.parseInt(strs[1]);

        arr = new int[N][M];

        for(int i = 0; i < N; ++i) {
            String str = br.readLine();
            for(int j = 0; j < M; ++j) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(dijkstra());
    }

    // 상하좌우
    static int[] dr = { -1, 1, 0, 0};
    static int[] dc = { 0, 0, -1, 1};

    static int dijkstra() {
        int[][] dist = new int[N][M];

        for(int i = 0; i < dist.length; ++i) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0,0,0));

        while (true) {
            Node curr = pq.poll();
            int r = curr.r;
            int c = curr.c;
            int cost = curr.cost;

            if(cost > dist[r][c]) continue;

            if(r == N-1 && c == M-1) {
                return cost;
            }

            for(int d = 0; d < 4; ++d) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                int newCost = cost + arr[nr][nc];

                if(newCost < dist[nr][nc]) {
                    dist[nr][nc] = newCost;
                    pq.add(new Node(nr,nc,newCost));
                }
            }


        }
    }
}