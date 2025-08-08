import java.io.*;
import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int to;
        long cost;
        
        Edge(int to, long cost) {
            this.to = to;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Edge o) {
            return Long.compare(this.cost, o.cost);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        // 적의 시야 정보
        boolean[] canVisit = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            canVisit[i] = Integer.parseInt(st.nextToken()) == 0;
        }
        canVisit[N - 1] = true; // 넥서스는 항상 방문 가능
        
        // 그래프 초기화
        List<Edge>[] graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long t = Long.parseLong(st.nextToken());
            
            graph[a].add(new Edge(b, t));
            graph[b].add(new Edge(a, t));
        }
        
        long result = dijkstra(graph, canVisit, N);
        System.out.println(result);
    }
    
    static long dijkstra(List<Edge>[] graph, boolean[] canVisit, int N) {
        long[] dist = new long[N];
        Arrays.fill(dist, Long.MAX_VALUE);
        
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        
        dist[0] = 0;
        pq.offer(new Edge(0, 0));
        
        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int now = current.to;
            long nowCost = current.cost;
            
            if (nowCost > dist[now]) continue;
            
            for (Edge next : graph[now]) {
                int nextNode = next.to;
                long nextCost = nowCost + next.cost;
                
                // 적의 시야에 있는 노드는 방문 불가 (넥서스 제외)
                if (!canVisit[nextNode]) continue;
                
                if (nextCost < dist[nextNode]) {
                    dist[nextNode] = nextCost;
                    pq.offer(new Edge(nextNode, nextCost));
                }
            }
        }
        
        return dist[N - 1] == Long.MAX_VALUE ? -1 : dist[N - 1];
    }
}