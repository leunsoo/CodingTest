import java.io.*;
import java.util.*;

class VO {
    int idx;
    int value;

    public VO(int idx, int value) {
        this.idx = idx;
        this.value = value;
    }
}

public class Main {
    private static VO[] origin;
    private static VO[] minSeg;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        origin = new VO[N+1];
        minSeg = new VO[(N+1)*4];

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; ++i) {
            origin[i] = new VO(i,Integer.parseInt(stk.nextToken()));
        }

        init(1,N,1);

        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; ++i) {
            stk = new StringTokenizer(br.readLine());

            int queryType = Integer.parseInt(stk.nextToken());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());

            if(queryType == 1) {
                update(1, N, a, b, 1);
            }
            else {
                sb.append(query(1, N, a, b, 1).idx).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static void init(int start, int end, int idx) {
        if(start == end) {
            minSeg[idx] = origin[start];
            return;
        }

        int mid = (start+end)/2;
        init(start, mid, idx*2);
        init(mid+1, end, idx*2+1);

        if(minSeg[idx*2].value <= minSeg[idx*2+1].value) {
            minSeg[idx] = minSeg[idx*2];
        }
        else {
            minSeg[idx] = minSeg[idx * 2 + 1];
        }
    }

    private static void update(int start, int end, int target, int value, int idx) {
        if(target < start || target > end) return;

        if(target == start && target == end) {
            origin[target] = new VO(start, value);
            minSeg[idx] = origin[target];
            return;
        }

        int mid = (start+end)/2;
        update(start, mid, target, value, idx*2);
        update(mid+1,end, target, value, idx*2+1);

        if(minSeg[idx*2].value <= minSeg[idx*2+1].value) {
            minSeg[idx] = minSeg[idx*2];
        }
        else {
            minSeg[idx] = minSeg[idx * 2 + 1];
        }
    }

    private static VO query(int start, int end, int qs, int qe, int idx) {
        if(qs > end || qe < start ) return null;

        if(qs <= start && end <= qe) {
            return minSeg[idx];
        }

        int mid = (start + end)/2;
        VO left = query(start,mid, qs, qe, idx*2);
        VO right = query(mid+1,end, qs, qe, idx*2+1);

        if(left == null) return right;
        if(right == null) return left;

        if(left.value <= right.value) {
            return left;
        }
        else
            return  right;
    }
}