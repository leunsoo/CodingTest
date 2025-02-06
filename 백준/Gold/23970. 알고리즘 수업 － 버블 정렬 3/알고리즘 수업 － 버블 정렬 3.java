import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arrSize = Integer.parseInt(br.readLine());

        int[] arr_1 = new int[arrSize];
        int[] arr_2 = new int[arrSize];

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < arrSize; ++i) {
            arr_1[i] = Integer.parseInt(stk.nextToken());
        }

        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < arrSize; ++i) {
            arr_2[i] = Integer.parseInt(stk.nextToken());
        }

        if (Arrays.equals(arr_1, arr_2)) {
            System.out.println(1);
            return;
        }

        for (int i = arrSize - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr_1[j] > arr_1[j + 1]) {
                    int tmp = arr_1[j];
                    arr_1[j] = arr_1[j + 1];
                    arr_1[j + 1] = tmp;
                    
                    if (arr_1[j] == arr_2[j] && arr_1[j+1] == arr_2[j+1] && Arrays.equals(arr_1, arr_2)) {
                        System.out.println(1);
                        return;
                    }
                }
            }
        }

        System.out.println(0);
    }
}
