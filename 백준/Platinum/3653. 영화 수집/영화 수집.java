import java.io.*;
import java.util.*;

public class Main {
    private static int[] origin;
    private static int[] seg;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; ++tc) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(stk.nextToken());
            int m = Integer.parseInt(stk.nextToken());

            seg = new int[(n+m+1)*4];
            origin = new int[n+1];

            for (int i = 1; i <= n; ++i) {
                origin[i] = n+1-i;
                update(1,n+m, origin[i], 1, 1);
            }

            int top = n;

            stk = new StringTokenizer(br.readLine());
            for(int i = 0; i < m; ++i) {
                int target = Integer.parseInt(stk.nextToken());
                sb.append(query(1, n+m, origin[target] + 1, n+m, 1 )).append(" ");

                update(1,n+m,origin[target], 0, 1 );
                origin[target] = ++top;
                update(1,n+m,origin[target], 1, 1 );

            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void update(int s, int e, int target, int value, int idx) {
        if(target < s || target > e) return;

        if(s==e) {
            seg[idx] = value;
            return;
        }

        int mid = (s+e)/2;
        update(s,mid,target,value,idx*2);
        update(mid+1,e,target,value,idx*2+1);

        seg[idx] = seg[idx*2] + seg[idx*2+1];
    }

    private static int query(int s, int e, int qs, int qe, int idx) {
        if (qe < s || e < qs) return 0;

        if(qs <= s && e <= qe) return seg[idx];

        int mid = (s+e)/2;
        return query(s,mid,qs,qe,idx*2) + query(mid+1,e,qs,qe,idx*2+1);
    }
}