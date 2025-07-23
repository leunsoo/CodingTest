import java.io.*;
import java.util.*;

public class Main {
    private static int[] origin;
    private static int[] seg;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        origin = new int[N+1];
        seg = new int[N*4];

        stk = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; ++i) {
            origin[i] = Integer.parseInt(stk.nextToken());
        }

        init(1,N,1);

        StringBuilder sb = new StringBuilder();
        for(int i = M; i <= N-M+1; ++i) {
            sb.append(query(1,N,i-M+1, i+M-1,1)).append(" ");
        }

        System.out.println(sb);
    }

    private static void init(int s, int e, int idx) {
        if(s==e) {
            seg[idx] = origin[s];
            return;
        }

        int mid = (s+e)/2;
        init(s, mid, idx*2);
        init(mid+1, e, idx*2+1);

        seg[idx] = Math.max(seg[idx*2], seg[idx*2+1]);
    }

    private static int query(int s, int e, int qs, int qe, int idx) {
        if(qe < s || e < qs) return 0;

        if(qs <= s && e <= qe) return seg[idx];

        int mid = (s+e)/2;

        return  Math.max(query(s,mid,qs,qe,idx*2), query(mid+1,e,qs,qe,idx*2+1));
    }
}