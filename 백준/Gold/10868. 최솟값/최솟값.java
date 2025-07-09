import java.io.*;
import java.util.*;

public class Main {
    private static int[] origin;
    private static int[] minSeg;
    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        origin = new int[N+1];
        minSeg = new int[(N+1)*4];

        for(int i = 1; i <= N; ++i) {
            origin[i] = Integer.parseInt(br.readLine());
        }

        init(1,N,1);

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < M; ++i) {
            stk = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());

            sb.append(query(1,N,start,end,1)).append("\n");
        }

        System.out.println(sb);
    }

    private static void init(int s, int e, int idx) {
        if(s == e) {
            minSeg[idx] = origin[s];
            return;
        }

        int mid = (s+e)/2;
        init(s, mid, idx*2);
        init(mid+1, e, idx*2+1);

        minSeg[idx] = Math.min(minSeg[idx*2], minSeg[idx*2+1]);
    }

    private static int query(int s, int e, int qs, int qe, int idx) {
        if(qe < s || e < qs) return Integer.MAX_VALUE;
        
        if(qs <= s && e <= qe) return minSeg[idx];

        int mid = (s+e)/2;
        int left = query(s, mid, qs, qe, idx*2);
        int right = query(mid+1, e, qs, qe, idx*2+1);

        return Math.min(left,right);
    }
}