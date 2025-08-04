import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        char[] vowel = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};

        StringBuilder sb = new StringBuilder();
        while (!(str = br.readLine()).equals("#") ) {
            int answer = 0;
            for(int i = 0; i < str.length(); ++i) {
                for(int j = 0; j < vowel.length; ++j) {
                    if(str.charAt(i) == vowel[j])
                    {
                        answer++;
                        break;
                    }
                }
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }

}