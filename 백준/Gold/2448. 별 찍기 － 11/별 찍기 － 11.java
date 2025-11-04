import java.io.*;

public class Main {
    static char[][] stars;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        stars = new char[N][2 * N - 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N - 1; j++) {
                stars[i][j] = ' ';
            }
        }
        
        drawTriangle(0, N - 1, N);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N - 1; j++) {
                sb.append(stars[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
    
    static void drawTriangle(int row, int col, int size) {
        if (size == 3) {
            stars[row][col] = '*';
            
            stars[row + 1][col - 1] = '*';
            stars[row + 1][col + 1] = '*';
            
            stars[row + 2][col - 2] = '*';
            stars[row + 2][col - 1] = '*';
            stars[row + 2][col] = '*';
            stars[row + 2][col + 1] = '*';
            stars[row + 2][col + 2] = '*';
            
            return;
        }
        
        int newSize = size / 2;
        drawTriangle(row, col, newSize);
        drawTriangle(row + newSize, col - newSize, newSize);
        drawTriangle(row + newSize, col + newSize, newSize);
    }
}