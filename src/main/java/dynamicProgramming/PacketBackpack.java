package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PacketBackpack {
    static int N = 110;
    static int[][] f = new int[N][N];
    static int[] v = new int[N];
    static int[] w = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] line = reader.readLine().split("\\s+");
        int n = Integer.parseInt(line[0]), V = Integer.parseInt(line[1]);
        for (int i = 1; i <= n; i++) {//读n组
            int m = Integer.parseInt(reader.readLine());
            for (int k = 1; k <= m; k++) {
                String[] list = reader.readLine().split("\\s+");
                int vTmp = Integer.parseInt(list[0]);
                v[k] = vTmp;
                int wTmp = Integer.parseInt(list[1]);
                w[k] = wTmp;
            }
            for (int j = 1; j <= V; j++) {
                for (int kk = 1; kk <= m; kk++) {
                    if (j >= v[kk]) {
                        f[i][j] = Math.max(f[i][j],Math.max(f[i-1][j], f[i - 1][j - v[kk]] + w[kk]));
                    } else {
                        f[i][j] = Math.max(f[i][j], f[i - 1][j]);
                    }
                    // System.out.print(f[i][j]+ " ");
                }
            }
            // System.out.println();
        }
        System.out.println(f[n][V]);
    }
}
