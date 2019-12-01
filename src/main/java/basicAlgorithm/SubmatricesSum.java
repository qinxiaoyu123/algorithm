package basicAlgorithm;

import java.util.Scanner;

public class SubmatricesSum {
    public static void main(String []args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), m = input.nextInt(), q = input.nextInt();
        int arry[][] = new int[n+1][m+1], sum[][] = new int[n+1][m+1];
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= m; j++)
                arry[i][j] = input.nextInt();
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= m; j++)
                sum[i][j] = sum[i][j-1] + sum[i-1][j] - sum[i-1][j-1] + arry[i][j];
        while (q-->0){
            int x1 = input.nextInt(), y1 = input.nextInt(), x2 = input.nextInt(), y2 = input.nextInt();
            System.out.println(sum[x2][y2]-sum[x1-1][y2]-sum[x2][y1-1]+sum[x1-1][y1-1]);
        }
    }
}
