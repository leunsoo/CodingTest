import java.io.*;
import java.util.*;

public class Main {
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        parent = new int[N+1];
        for(int i = 1; i <= N; ++i) {
            parent[i] = i;
        }

        for(int i = 1; i <= N; ++i) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; ++j) {
                int connected = Integer.parseInt(stk.nextToken());
                if( connected == 1) {
                    union(i,j);
                }
            }
        }

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int[] plan = new int[M];
        for(int i = 0; i < M; ++i) {
            plan[i] = Integer.parseInt(stk.nextToken());
        }

        boolean isPossible = true;
        int root = find(plan[0]);

        for(int i = 1; i< M; ++i) {
            if(find(plan[i]) != root) {
                isPossible = false;
                break;
            }
        }

        System.out.println(isPossible ? "YES" : "NO");
    }

    private static int find(int x) {
        if(parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    private static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if(rootX != rootY) {
            parent[rootY] = rootX;
        }
    }
}