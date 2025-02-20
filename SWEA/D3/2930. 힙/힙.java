import java.io.*;
import java.util.*;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
 
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Comparator.reverseOrder());
 
        for (int tc = 1; tc <= T; ++tc) {
            pq.clear();
            int commandCnt = Integer.parseInt(br.readLine().trim());
            bw.write("#" + tc);
 
            for (int i = 0; i < commandCnt; ++i) {
                String[] str = br.readLine().trim().split(" ");
                if (str.length == 1) {
                    if (pq.isEmpty()) {
                        bw.write(" -1");
                    }
                    else {
                        bw.write(" " + pq.poll());						
					}
 
                } else if(str.length == 2) {
                    pq.offer(Integer.parseInt(str[1]));
                }
            }
            bw.write("\n");
            
        }
 
        bw.flush();
        bw.close();
    }
}