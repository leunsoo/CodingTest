import java.io.*;
import java.util.*;

public class Main {
    static  class Edge {
        int to, weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static List<Edge>[] graph;
    static int N, M;

    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        graph = new ArrayList[N+1];
        for(int i = 1; i <= N; ++i) {
            graph[i] = new ArrayList<>();
        }

        int maxWeight = 0;

        for(int i = 0; i < M; ++i) {
            stk = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(stk.nextToken());
            int B = Integer.parseInt(stk.nextToken());
            int C = Integer.parseInt(stk.nextToken());

            graph[A].add(new Edge(B,C));
            graph[B].add(new Edge(A,C));

            maxWeight = Math.max(maxWeight,C);
        }

        stk = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(stk.nextToken());
        int end = Integer.parseInt(stk.nextToken());

        int result = parametricSearch(start,end,maxWeight);
        System.out.println(result);
    }

    static int parametricSearch(int start, int end, int maxWeight) {
        int left = 1;
        int right = maxWeight;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if(canReach(start,end,mid)) {
                answer = mid;
                left = mid+1;
            }
            else {
                right = mid -1;
            }
        }

        return  answer;
    }

    //limit 중량으로 start에서 end로 갈 수 있?
    static  boolean canReach(int start, int end, int weightLimit) {
        boolean[] visited = new boolean[N+1];
        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            if(curr == end) return true;

            for(Edge e : graph[curr]) {
                int next = e.to;
                int weight = e.weight;

                if(!visited[next] && weight >= weightLimit) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }

        return  false;
    }
}