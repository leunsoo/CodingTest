import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int L = Integer.parseInt(br.readLine()); 
        String str = br.readLine(); 
        
        // 해싱 계산
        long hash = 0;
        long base = 31;      
        long mod = 1234567891L;
        long power = 1;    
        
        for (int i = 0; i < L; i++) {
            int charValue = str.charAt(i) - 'a' + 1;
            hash = (hash + (charValue * power) % mod) % mod;
            
            power = (power * base) % mod;
        }
        
        System.out.println(hash);
    }
}