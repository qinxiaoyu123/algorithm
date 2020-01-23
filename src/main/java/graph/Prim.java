package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Prim {
    static int n, res;
    static int N = 510;
    static int INF = 0x3f3f3f3f;
    static int[][] g = new int[N][N];
    static int[] dist = new int[N];
    static boolean[] st = new boolean[N];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] line = reader.readLine().split("\\s");
        n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        //为什么这种情况初始化就全为最大值
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=n;j++){
                g[i][j] = INF;
            }
        }
        while (m-- > 0) {
            String[] list = reader.readLine().split("\\s");
            int a = Integer.parseInt(list[0]), b = Integer.parseInt(list[1]), c = Integer.parseInt(list[2]);
            //无向图两个方向都要赋值
            g[a][b] = Math.min(g[a][b], c);
            g[b][a] = Math.min(g[a][b], c);
        }
        int t = prim();
        if (t == INF ) System.out.println("impossible");
        else System.out.println(t);
    }

    private static int prim() {
        Arrays.fill(dist,0x3f3f3f3f);
        int res = 0;
        for (int i = 0; i < n; i ++ )
        {
            int t = -1;
            for (int j = 1; j <= n; j ++ )
                if (!st[j] && (t == -1 || dist[t] > dist[j]))
                    t = j;

            if (i>0 && dist[t] == INF) return INF;

            if (i>0) res += dist[t];
            st[t] = true;

            for (int j = 1; j <= n; j ++ ) dist[j] = Math.min(dist[j], g[t][j]);
        }
        return res;
    }
}
