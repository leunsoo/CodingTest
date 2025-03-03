import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pn = new PriorityQueue<>();
		PriorityQueue<Integer> nn = new PriorityQueue<>(Collections.reverseOrder());
 		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = 0; i < N; ++i) {
			int num = Integer.parseInt(br.readLine());
			
			if(num == 0) { // 출력 
				
				if(pn.isEmpty() && nn.isEmpty()) {
					bw.write("0\n");
				}
				else if (pn.isEmpty()) {
					bw.write(nn.poll()+"\n");
				}
				else if (nn.isEmpty()) {
					bw.write(pn.poll()+"\n");
				}
				else {
					int n1 = Math.abs(pn.peek());
					int n2 = Math.abs(nn.peek());
					
					if(n1 < n2) {
						bw.write(pn.poll()+"\n");
					}
					else {
						bw.write(nn.poll()+"\n");
					}
				}
			}
			else if( num > 0)
			{
				pn.add(num);
			}
			else 
			{
				nn.add(num);
			}
		}
		bw.flush();
	}	
}