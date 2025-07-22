import java.io.*;
import java.util.*;

public class Main {
    private static int[] seg;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        seg = new int[N*4];

        int[] A = new int[N];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; ++i) {
            A[i] = Integer.parseInt(stk.nextToken());
        }

        Map<Integer, Integer> BPos = new HashMap<>();
        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; ++i) {
            int machine = Integer.parseInt(stk.nextToken());
            BPos.put(machine, i+1);
        }

        long inversion = 0;
        for(int i = 0; i < N; ++i) {
            int machine = A[i];
            int pos = BPos.get(machine);

            inversion += query(1, N, pos+1, N, 1);

            update(1,N,pos,1,1);
        }

        System.out.println(inversion);
    }

    private static void update(int s, int e, int target, int value, int idx) {
        if(target < s || e < target) return;

        if( s == e) {
            seg[idx] += value;
            return;
        }

        int mid = (s+e)/2;
        update(s,mid,target,value,idx*2);
        update(mid+1,e,target,value,idx*2+1);

        seg[idx] = seg[idx*2] + seg[idx*2+1];
    }

    private static int query(int s, int e, int qs, int qe, int idx) {
        if( qe < s || e < qs) return 0;

        if(qs <= s && e <= qe) return seg[idx];

        int mid = (s+e)/2;

        return query(s,mid,qs,qe,idx*2) + query(mid+1,e,qs,qe,idx*2+1);
    }
}