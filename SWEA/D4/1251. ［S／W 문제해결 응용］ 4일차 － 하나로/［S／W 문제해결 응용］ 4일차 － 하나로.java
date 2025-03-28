import java.io.*;
import java.util.*;

class Island {
    int x, y;
    public Island(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Node implements Comparable<Node> {
    int idx;
    double dist;
    
    public Node(int idx, double dist) {
        this.idx = idx;
        this.dist = dist;
    }
    
    // 거리가 작은 순으로 정렬
    @Override
    public int compareTo(Node o) {
        return Double.compare(this.dist, o.dist);
    }
}

public class Solution {
    static Island[] islands;
    static int N;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            
            N = Integer.parseInt(br.readLine());
            islands = new Island[N];
            
            // 섬의 x좌표 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                islands[i] = new Island(Integer.parseInt(st.nextToken()), 0);
            }
            
            // 섬의 y좌표 입력
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                islands[i].y = Integer.parseInt(st.nextToken());
            }
            double tax = Double.parseDouble(br.readLine());
            
            sb.append(Math.round(prim() * tax)).append("\n");
        }
        System.out.print(sb.toString());
    }
    
    // 두 섬 사이의 거리 계산
    private static double getDist(int x1, int x2, int y1, int y2) {
        double dx = x1 - x2;
        double dy = y1 - y2;
        return dx * dx + dy * dy;
    }
    
    private static double prim() {
    	double answer = 0;

    	boolean[] visited = new boolean[N]; // 사이클 방지용, 현재 MST 집합에 속해있느냐
    	double[] dist = new double[N]; // 해당 인덱스의 섬과 연결된 최소 터널 길이 
    	
    	
    	Arrays.fill(dist, Double.MAX_VALUE);
    	
    	// MST 그리디의 성질을 이용할 PQ
    	PriorityQueue<Node> pq = new PriorityQueue<>();
    	pq.add(new Node(0, 0));
    	dist[0] = 0;
    	
    	int cnt = 0;
    	while (cnt < N) {
			Node curr = pq.poll();
			
			if(visited[curr.idx]) continue; // 사이클 방지 
			visited[curr.idx] = true;
			answer += curr.dist;
			cnt++;
			
			//인접한 노드들 탐색
			for(int to = 0; to < N; ++to) {
				if(visited[to]) continue;
				
				double newDist = getDist(islands[curr.idx].x, islands[to].x, islands[curr.idx].y, islands[to].y);
				
				if(dist[to] <= newDist) continue;
				
				dist[to] = newDist;
				pq.add(new Node(to, newDist));
			}
			
		}
    	
    	return answer;
    }
    
}
