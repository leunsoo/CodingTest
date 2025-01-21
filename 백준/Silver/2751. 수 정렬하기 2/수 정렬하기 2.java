import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arrSize = Integer.parseInt(br.readLine());
        int[] intArr = new int[arrSize];
        
        for(int i = 0; i < arrSize; ++i)
        {
            intArr[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(intArr);
        
        StringBuffer sb = new StringBuffer();
        for(int num : intArr)
        {
            sb.append(num).append("\n");
        }
        System.out.println(sb.toString());
    }
}