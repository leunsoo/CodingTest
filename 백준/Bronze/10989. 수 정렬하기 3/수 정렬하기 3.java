import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.io.InputStreamReader;

public class Main
{
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
        
        for(int i = 0; i < arrSize; ++i)
        {
            sb.append(intArr[i]).append("\n");
        }
        
        System.out.print(sb.toString());
    }
}