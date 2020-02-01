package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DigitalTriangle {
    //    static int idx = 0;
    static int N = 510;
    static int INF = -0x3f3f3f3f;
    static int[][] g = new int[N][N];
    static int[][] f = new int[N][N];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= n; i++) {
            int idx = 1;
            for (String s : reader.readLine().split("\\s+")) {
                g[i][idx++] = Integer.parseInt(s);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                f[i][j] = INF;
            }
        }
        f[1][1] = g[1][1];
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (1 <= j && j <= i) {
                    f[i][j] = Math.max(f[i - 1][j] + g[i][j], f[i][j]);
                }
                if (1 <= j - 1 && j - 1 <= i) {
                    f[i][j] = Math.max(f[i - 1][j - 1] + g[i][j], f[i][j]);
                }
            }
        }
        int res = INF;
        for (int i = 1; i <= n; i++) {
            res = Math.max(f[n][i], res);
        }
        System.out.println(res);
    }
}
