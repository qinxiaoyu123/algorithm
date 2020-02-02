package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestCommonSubsequence {
    static int N = 1010;
    static int[][] f = new int[N][N];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] line = reader.readLine().split("\\s+");
        int n1 = Integer.parseInt(line[0]), n2 = Integer.parseInt(line[1]);
        char[] a = reader.readLine().toCharArray();
        char[] b = reader.readLine().toCharArray();
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n1; j++) {
                f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                if (a[i] == b[j]) f[i][j] = Math.max(f[i - 1][j - 1] + 1, f[i][j]);
            }
        }
        System.out.println(f[n1][n2]);
    }
}
