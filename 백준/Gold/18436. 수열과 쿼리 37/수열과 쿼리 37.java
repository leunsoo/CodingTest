import java.io.*;
import java.util.*;

public class Main {
    private static int[] origin;
    private static int[] odd;
    private static int[] even;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        origin = new int[N+1];
        odd = new int[(N+1)*4];
        even = new int[(N+1)*4];

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; ++i) {
            origin[i] = Integer.parseInt(stk.nextToken());
        }
        
       init(1,N,1);

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; ++i) {
            stk = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(stk.nextToken());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());

            if(cmd == 1) {
            	update(1,N,a,b,1);
            }
            else if(cmd == 2) {
            	sb.append(query(1,N,a,b,1,cmd)).append("\n");
            }
            else {
				sb.append(query(1,N,a,b,1,cmd)).append("\n");
			}
        }
        
        System.out.println(sb);
    }

    private static void init(int s, int e, int idx) {
    	if(s == e) {
    		if(origin[s]%2 == 0) {
    			even[idx] = 1;
    		}
    		else {
				odd[idx] = 1;
			}
    		return;
    	}
    	
    	int mid = (s+e)/2;
    	init(s, mid, idx*2);
    	init(mid+1, e, idx*2+1);
    	
    	even[idx] = even[idx*2] + even[idx*2+1];
    	odd[idx] = odd[idx*2] + odd[idx*2+1];
    }

    private static void update(int s, int e, int target, int value, int idx) {
    	if(target < s || target > e) return;
    	
    	if(s == target && e == target) {
    		origin[target] = value;
    		if(value%2 == 0) {
    			even[idx] = 1;
    			odd[idx] = 0;
    		}
    		else {
				even[idx] = 0;
				odd[idx] = 1;
			}
    		return;
    	}
    	
    	int mid = (s+e)/2;
    	update(s, mid, target, value, idx*2);
    	update(mid+1, e, target, value, idx*2+1);
    	
    	even[idx] = even[idx*2] + even[idx*2+1];
    	odd[idx] = odd[idx*2] + odd[idx*2+1];
    }

    private static int query(int s, int e, int qs, int qe, int idx, int type) {
    	if(qe < s || e < qs) return 0;
    	
    	if(qs <= s && e <= qe) {
        	if(type == 2) return even[idx];
        	if(type == 3) return odd[idx];
    	}
    	
    	int mid = (s+e)/2;
    	int left = query(s,mid,qs,qe,idx*2,type);
    	int right = query(mid+1,e,qs,qe,idx*2+1,type);
    	
    	return left+right;
    }
}