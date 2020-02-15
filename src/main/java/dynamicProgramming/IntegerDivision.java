package dynamicProgramming;

import java.util.Scanner;
//背包解法
public class IntegerDivision {
    static int N = 1010;
    static int[] f = new int[N];

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int mod = 1000000007;
        //只有f[0,0]才有解
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                f[j] = (f[j] + f[j - i]) % mod;
            }
        }
        System.out.println(f[n]);
    }
}
