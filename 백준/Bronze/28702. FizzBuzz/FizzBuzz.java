import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] strs = new String[3];
        for (int i = 0; i < 3; i++) {
            strs[i] = br.readLine();
        }
        
        int nextNumber = 0;
        
        for (int i = 0; i < 3; i++) {
            if (!strs[i].equals("Fizz") && !strs[i].equals("Buzz") && !strs[i].equals("FizzBuzz")) {
                int currentNum = Integer.parseInt(strs[i]);
                nextNumber = currentNum + (3 - i);
                break;
            }
        }
        
        if (nextNumber % 15 == 0) {
            System.out.println("FizzBuzz");
        } else if (nextNumber % 3 == 0) {
            System.out.println("Fizz");
        } else if (nextNumber % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(nextNumber);
        }
    }
}