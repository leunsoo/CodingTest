import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class People implements Comparable<People> {
		int age; 
		String name;
		
		public People(int age, String name) {
			this.age = age;
			this.name = name;
		}
		
		@Override
		public int compareTo(Main.People o) {
			if(this.age == o.age) {
				return -1;
			}
			return this.age - o.age;
		}
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        People[] people = new People[T];
        
        for(int i =0 ; i < T; ++i) {
        	StringTokenizer stk = new StringTokenizer(br.readLine());
        	int age = Integer.parseInt(stk.nextToken());
        	people[i] =new People(age, stk.nextToken());
        }
        
        Arrays.sort(people, (a, b) -> Integer.compare(a.age, b.age));
        
        StringBuilder sb = new StringBuilder();
        for(People p : people) {
        	sb.append(p.age).append(" ").append(p.name).append("\n");
        }
        
        System.out.println(sb);
    }
}