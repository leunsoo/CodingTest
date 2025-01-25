import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int num = Integer.parseInt(str[0]);
		int k = Integer.parseInt(str[1]);

		int[] intArr = new int[num];
		boolean[] boolArr = new boolean[num];
		
		for (int i = 0; i < num; ++i) {
			intArr[i] = i+1;
		}
		
		StringBuilder answer = new StringBuilder();
		answer.append("<");
		int idx = 0;
		int answerCount = 0;
		
		while (answerCount != num) {
			
			for(int i = 0; i < num; ++i)
			{
				if(boolArr[i]) continue;
				
				if(++idx == k)
				{
					idx = 0;
					answerCount++;
					boolArr[i] = true;
					answer.append(intArr[i]).append(", ");
				}
			}
		}

		answer.delete(answer.length()-2, answer.length()).append(">");
		System.out.print(answer);
	}
}