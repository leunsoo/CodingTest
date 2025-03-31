import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1_000_000_007;
    static long[] arr;
    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());

        arr = new long[N + 1];
        tree = new long[4 * N];

        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        init(1, 1, N);

        StringBuilder sb = new StringBuilder();
        int Q = M + K;

        while (Q-- > 0) {
            stk = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(stk.nextToken());

            if (type == 1) {
                int idx = Integer.parseInt(stk.nextToken());
                long val = Long.parseLong(stk.nextToken());
                arr[idx] = val;
                update(1, 1, N, idx, val);
            } else {
                int l = Integer.parseInt(stk.nextToken());
                int r = Integer.parseInt(stk.nextToken());
                sb.append(query(1, 1, N, l, r)).append("\n");
            }
        }

        System.out.print(sb);
    }

    static long init(int node, int start, int end) {
        if (start == end) return tree[node] = arr[start];
        int mid = (start + end) / 2;
        return tree[node] = (init(node * 2, start, mid) * init(node * 2 + 1, mid + 1, end)) % MOD;
    }

    static void update(int node, int start, int end, int idx, long val) {
        if (idx < start || idx > end) return;

        if (start == end) {
            tree[node] = val;
            return;
        }

        int mid = (start + end) / 2;
        update(node * 2, start, mid, idx, val);
        update(node * 2 + 1, mid + 1, end, idx, val);
        tree[node] = (tree[node * 2] * tree[node * 2 + 1]) % MOD;
    }

    static long query(int node, int start, int end, int l, int r) {
        if (r < start || end < l) return 1;
        if (l <= start && end <= r) return tree[node];
        int mid = (start + end) / 2;
        return (query(node * 2, start, mid, l, r) * query(node * 2 + 1, mid + 1, end, l, r)) % MOD;
    }
}
