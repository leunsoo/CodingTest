import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int hashSize = Integer.parseInt(br.readLine());

		StringTokenizer stk = new StringTokenizer(br.readLine());
		HashMap<Integer, Integer> cardHash = new HashMap<Integer, Integer>(hashSize);

		for (int i = 0; i < hashSize; ++i) {
			cardHash.put(Integer.parseInt(stk.nextToken()), 1);
		}

		int compareSize = Integer.parseInt(br.readLine());
		stk = new StringTokenizer(br.readLine());

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < compareSize; ++i) {
			sb.append(cardHash.getOrDefault(Integer.parseInt(stk.nextToken()), 0)).append(" ");
		}
		
		System.out.println(sb.toString());
	}
}