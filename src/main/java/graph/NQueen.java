package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NQueen {

    static int n, N= 20;
    static char[][] graph = new char[N][N];
    static boolean[] dg = new boolean[N];
    static boolean[] udg = new boolean[N];
    static boolean[] col = new boolean[N];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=n;j++)
                graph[i][j] = '.';
        }
        dfs(1);
    }

    private static void dfs(int u) {
        for (int i = 1; i <= n; i++) {
            if (!col[i] && !dg[u-i+n] && !udg[u+i]){
                graph [u][i] = 'Q';
                if(u == n) {
                    printGraph();
                    graph [u][i] = '.';
                    return;
                }


                col[i] = true;
                dg[u-i+n] = true;
                udg[u+i] = true;

                dfs(u+1);
                graph [u][i] = '.';
                col[i] = false;
                dg[u-i+n] = false;
                udg[u+i] = false;
            }
        }
    }

    private static void printGraph() {
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=n;j++)
                System.out.print(graph[i][j]);
            System.out.println();
        }
        System.out.println();
    }
}
