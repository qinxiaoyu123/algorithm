package dynamicProgramming;

import java.util.Scanner;

public class IntegerDivison1 {
    static int N = 1010;
    static int[][] f = new int[N][N];
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int mod = 1000000007;
        //只有f[0,0]才有解
        f[1][1]= 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                f[i][j] = (f[i-1][j-1] + f[i-j][j]) % mod;
            }
        }
        int res = 0;
        for(int i = 1;i<= n;i++)
            res = (res+ f[n][i]) % mod;
        System.out.println(res);
    }
}
