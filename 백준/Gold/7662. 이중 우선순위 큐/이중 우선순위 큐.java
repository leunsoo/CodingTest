import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine()); 
        
        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine()); 
            
            TreeMap<Integer, Integer> map = new TreeMap<>();
            
            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char operation = st.nextToken().charAt(0);
                int num = Integer.parseInt(st.nextToken());
                
                if (operation == 'I') {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else {
                    if (map.isEmpty()) {
                        continue; 
                    }
                    
                    int key;
                    if (num == 1) {
                        key = map.lastKey();
                    } else {
                        key = map.firstKey();
                    }
                    
                    if (map.put(key, map.get(key) - 1) == 1) {
                        map.remove(key); 
                    }
                }
            }
            
            if (map.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
            }
        }
        
        System.out.print(sb);
    }
}