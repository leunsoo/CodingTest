import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            int dist = y - x;
            
            int n = (int) Math.sqrt(dist);
            
            if(n*n == dist) {
            	sb.append(2*n-1).append("\n");
            }
            else if(n*n < dist && dist <= n*n+n) {
            	sb.append(2*n).append("\n");
            }
            else{
            	sb.append(2*n+1).append("\n");
            }
        }
        System.out.print(sb);
    }
}
