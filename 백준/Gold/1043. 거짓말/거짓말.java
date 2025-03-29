import java.io.*;
import java.util.*;

public class Main {
	static int[] parents;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken()); // 사람 수 
        int M = Integer.parseInt(stk.nextToken()); // 파티 수 

        // N+1 개의 parents
        parents = new int[N+1];
        for(int i = 0; i <= N; ++i) {
        	parents[i] = i;
        }
        
        // M 개의 파티 배열 => 대표자 저장용 
        int[] party = new int[M];
        
        // 진실을 아는 사람
        stk = new StringTokenizer(br.readLine());
        int trueCnt = Integer.parseInt(stk.nextToken());
        ArrayList<Integer> trues = new ArrayList<>(); 
        for(int i = 0 ; i < trueCnt; ++i) {
        	trues.add(Integer.parseInt(stk.nextToken()));
        }
        
        if(trueCnt == 0) { //진실을 아는 사람이 없을 시 모든 파티 참석 가능 
        	System.out.println(M);
        	return;
        }
        
        // 각 파티(참석자가 2이상 일 시) 유니온 파인드
        for(int i = 0; i < M; ++i) {
        	stk = new StringTokenizer(br.readLine());
        	int cnt = Integer.parseInt(stk.nextToken()); // 파티 참석자 수 
        	
        	int a = Integer.parseInt(stk.nextToken());
        	cnt--;
        	party[i] = parents[a]; // 초기 대표 
        	
        	for(int j = 0; j < cnt; ++j) { // 파티 집합 
        		int b = Integer.parseInt(stk.nextToken());
        		party[i] = union(a, b);
        	}
        }
        
        int res = 0;
        // 파티 대표와 진실을 아는 사람들과 find, 대표가 다르면 res++ 
        for(int i = 0; i < M; ++i) {
        	boolean isDiffer = true;
        	for(int j = 0; j < trueCnt; ++j) {
        		if(find(trues.get(j)) == find(party[i])) {
        			isDiffer = false;
        			break;
        		}
        	}
        	
        	if(isDiffer) res++;
        }
        
        System.out.println(res);
    }
    
    static int find(int x) {
    	if(parents[x] == x) return x;
    	return parents[x] = find(parents[x]);
    }
    
    static int union(int a, int b) {
    	int rootA = find(a);
    	int rootB = find(b);
    	
    	parents[rootB] = rootA;
    	return rootA;
    }
}
