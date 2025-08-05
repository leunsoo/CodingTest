import java.io.*;
import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int to, cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    static List<Edge>[] graph;
    static int[] dist;
    static int[] parent; // 경로 복원용
    static final int INF = 1234567890;

    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n+1];
        for(int i = 1; i <= n; ++i) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; ++i) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(stk.nextToken());
            int to = Integer.parseInt(stk.nextToken());
            int cost = Integer.parseInt(stk.nextToken());

            graph[from].add(new Edge(to,cost));
        }

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(stk.nextToken());
        int end = Integer.parseInt(stk.nextToken());

        dijkstra(n,start);

        System.out.println(dist[end]);

        ArrayDeque<Integer> path = getPath(start,end);
        System.out.println(path.size());

        StringBuilder sb = new StringBuilder();

        while (!path.isEmpty()) {
            sb.append(path.pop()).append(" ");
        }

        System.out.println(sb);
    }

    static void dijkstra(int n, int start) {
        dist = new int[n+1];
        parent = new int[n+1];

        Arrays.fill(dist,INF);
        Arrays.fill(parent, -1);

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            int now = curr.to;
            int nowCost = curr.cost;

            if(nowCost > dist[now]) continue;

            for (Edge next : graph[now]) {
                int nextNode = next.to;
                int nextCost = nowCost + next.cost;

                if(nextCost < dist[nextNode]) {
                    dist[nextNode] = nextCost;
                    parent[nextNode] = now; // 노드 저장
                    pq.add(new Edge(nextNode, nextCost));
                }
            }
        }
    }

    static ArrayDeque<Integer> getPath(int start, int end) {
        ArrayDeque<Integer> path = new ArrayDeque<>();

        int current = end;
        while( current != -1) {
            path.push(current);
            current = parent[current];
        }

        return path;
    }
}