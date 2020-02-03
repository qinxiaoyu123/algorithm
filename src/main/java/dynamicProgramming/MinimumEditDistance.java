package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinimumEditDistance {
    static int N = 1010;
    static int[][] f = new int[N][N];
    public static void main(String []args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n1 = Integer.parseInt(reader.readLine());
        char [] a = reader.readLine().toCharArray();
        int n2 = Integer.parseInt(reader.readLine());
        char [] b = reader.readLine().toCharArray();
        reader.close();
        //增n次
        for(int i = 0; i<= n2; i++) f[0][i] = i;
        //删n次
        for(int i = 0; i<= n1; i++) f[i][0] = i;
        for(int i = 1;i<=n1;i++){
            for(int j =1;j<=n2;j++){
                f[i][j] = Math.min(f[i-1][j]+1, f[i][j-1]+1);
                if(a[i-1] == b[j-1]) f[i][j] = Math.min(f[i][j], f[i-1][j-1]);
                else f[i][j] = Math.min(f[i][j], f[i-1][j-1]+1);
            }
        }
        System.out.println(f[n1][n2]);
    }
}
