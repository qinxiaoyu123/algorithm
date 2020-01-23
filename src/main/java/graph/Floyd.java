package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Floyd {
    static int N = 202;
    static int INF = 0x3f3f3f3f;
    static int[][] d = new int[N][N];
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] line = reader.readLine().split("\\s");
        n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]), k = Integer.parseInt(line[2]);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) d[i][j] = 0;
                else d[i][j] = INF;
            }
        }
        while (m-- > 0) {
            String[] list = reader.readLine().split("\\s");
            int a = Integer.parseInt(list[0]), b = Integer.parseInt(list[1]), c = Integer.parseInt(list[2]);
            d[a][b] = Math.min(d[a][b], c);
        }
        floyd();
        while (k-- > 0) {
            String[] list = reader.readLine().split("\\s");
            int a = Integer.parseInt(list[0]), b = Integer.parseInt(list[1]);
            if (d[a][b] > INF / 2) System.out.println("impossible");
            else System.out.println(d[a][b]);
        }
    }

    private static void floyd() {
        for (int k = 1; k <= n; k++)
            for (int i = 1; i <= n; i++)
                for (int j = 1; j <= n; j++)
                    d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
    }
}
