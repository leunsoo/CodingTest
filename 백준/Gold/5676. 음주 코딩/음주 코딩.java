import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    private static int[] origin;
    private static int[] seg;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String str = br.readLine();

            if(str == null) break;

            StringTokenizer stk = new StringTokenizer(str);

            int N = Integer.parseInt(stk.nextToken());
            int K = Integer.parseInt(stk.nextToken());

            origin = new int[N+1];
            seg = new int[(N+1)*4];

            stk = new StringTokenizer(br.readLine());
            for(int i = 1; i <= N; ++i) {
                int num = Integer.parseInt(stk.nextToken());

                if(num > 0) num = 1;
                if(num < 0) num = -1;

                origin[i] = num;
            }

            init(1,N,1);

            for(int i = 0; i < K; ++i) {
                stk = new StringTokenizer(br.readLine());

                String cmd = stk.nextToken();
                int a = Integer.parseInt(stk.nextToken());
                int b = Integer.parseInt(stk.nextToken());

                if(cmd.equals("C")) {
                    update(1,N,a,b,1);
                }
                else {
                    int num = query(1,N,a,b,1);
                    String answer = "";

                    if(num == 1) answer = "+";
                    if(num == 0) answer = "0";
                    if(num == -1) answer = "-";

                    sb.append(answer);
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static void init(int left, int right, int idx) {
        if(left == right) {
            seg[idx] = origin[left];
            return;
        }

        int mid = (left+right)/2;
        init(left, mid, idx*2);
        init(mid+1, right, idx*2+1);

        seg[idx] = seg[idx*2] * seg[idx*2+1];
    }

    private static void update(int left, int right, int target, int value, int idx) {
        if(target < left || target > right) return;

        if(target == left && target == right) {
            int tmp = 0;
            if(value > 0) tmp = 1;
            if(value < 0) tmp = -1;

            origin[left] = tmp;
            seg[idx] = tmp;
            return;
        }

        int mid = (left+right)/2;
        update(left, mid, target, value, idx*2);
        update(mid+1, right, target, value, idx*2+1);

        seg[idx] = seg[idx*2] * seg[idx*2+1];
    }

    private static int query(int s, int e, int qs, int qe, int idx) {
        if(qe < s || e < qs) return 1;

        if(qs <= s && e <= qe) return seg[idx];

        int mid = (s+e)/2;
        int left = query(s,mid,qs,qe,idx*2);
        int right = query(mid+1,e,qs,qe,idx*2+1);

        return left*right;
    }
}