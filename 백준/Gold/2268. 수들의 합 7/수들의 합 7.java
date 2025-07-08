import java.io.*;
import java.util.*;

public class Main {
    private static long[] sumSeg;
    private static int N; // 수의 개수
    private static int M; // 명령의 개수

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        sumSeg = new long[(N+1)*4];

        for(int i = 0; i < M; ++i) {
            stk = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(stk.nextToken());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());

            if(cmd == 0) {
                if(a > b ) {
                    int tmp = a;
                    a = b;
                    b = tmp;

                }
                sb.append(query(1,N,1,a,b)).append("\n");
            }
            else {
                update(1,N,1 ,a,b);
            }
        }

        System.out.println(sb);
    }

    private static long query(int s, int e, int idx, int qs, int qe) {
        if(qe < s || qs > e) return 0;

        if(qs <= s && e <= qe) return sumSeg[idx];

        int mid = (s+e)/2;
        long left = query(s, mid, idx*2, qs, qe);
        long right = query(mid+1 , e, idx*2+1, qs, qe);

        return left + right;
    }

    private static void update(int s, int e, int idx, int target, int n) {
        if(s > target || e < target) return;

        if(s == target && e == target)
        {
            sumSeg[idx] = n;
            return;
        }

        int mid = (s+e)/2;
        update(s, mid, idx*2, target, n);
        update(mid+1, e, idx*2+1, target, n);

        sumSeg[idx] = sumSeg[idx*2] + sumSeg[idx*2+1];
    }
}