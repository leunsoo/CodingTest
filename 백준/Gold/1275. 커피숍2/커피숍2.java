import java.io.*;
import java.util.*;

public class Main {
    private static int[] origin;
    private static long[] sumSeg;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk= new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int Q = Integer.parseInt(stk.nextToken());

        origin = new int[N+1];
        sumSeg = new long[(N+1)*4];

        //할당
        stk = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; ++i) {
            origin[i] = Integer.parseInt(stk.nextToken());
        }

        //초기화
        init(1,N,1);

        //쿼리 및 업데이트
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < Q; ++i) {
            stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());

            if(x > y) {
                int tmp = x;
                x = y;
                y = tmp;
            }
            sb.append(query(1,N,x,y,1)).append("\n");
            update(1,N,1,a,b);
        }

        System.out.print(sb);
    }

    private static void init(int s, int e, int idx) {
        if(s==e) {
            sumSeg[idx] = origin[s];
            return;
        }

        int mid = (s+e)/2;
        init(s, mid, idx*2);
        init(mid+1, e, idx*2+1);

        sumSeg[idx] = sumSeg[idx*2] + sumSeg[idx*2+1];
    }

    private static void update(int s, int e, int idx, int target, int n){
        if(target < s || e <target ) return;

        if(s == target && e == target) {
            origin[s] = n;
            sumSeg[idx] = n;
            return;
        }

        int mid = (s+e)/2;
        update(s, mid, idx*2, target, n);
        update(mid+1, e, idx*2+1, target, n);

        sumSeg[idx] = sumSeg[idx*2] + sumSeg[idx*2+1];
    }

    private static long query(int s, int e, int qs, int qe, int idx) {
        if(qe < s || e < qs ) return 0;

        if(qs <= s && e <= qe) return sumSeg[idx];

        int mid = (s+e)/2;
        long left = query(s, mid, qs, qe, idx*2);
        long right = query(mid+1, e, qs, qe, idx*2+1);

        return left+right;
    }
}