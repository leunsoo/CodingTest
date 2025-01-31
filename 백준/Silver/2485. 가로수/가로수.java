
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		int[] intArr = new int[size];

		int min = 1000000001;

		for (int i = 0; i < size; ++i) {
			intArr[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 1; i < size; ++i) {
			int dist = intArr[i] - intArr[i - 1];

			min = min < dist ? min : dist;
		}
		
		while (min > 0) {
			int answer = 0;
			boolean isAnswer = true;
			int dist = min;
			
			for (int i = 0; i < size - 1;) {

				if (intArr[i] + dist == intArr[i + 1])
				{
					 ++i;
					 dist = min;
					continue;
				}

				if (intArr[i] + dist > intArr[i + 1]) 
				{
					isAnswer = false;
					break;
				} 
				else if (intArr[i] + dist < intArr[i + 1]) 
				{
					dist += min;
					answer++;
				}
			}
			min--;
			
			if(isAnswer)
			{
				System.out.println(answer);
				return;
			}
		}
	}
}
