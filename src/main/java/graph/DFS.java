package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DFS {
    static int N = 8;
    static int n;
    static int[] output = new int[N];
    static boolean[] flag = new boolean[N];
    static int idx = -1;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());

        dfs(1);
    }

    public static void print(int[] a) {
        for (int i = 1; i <= n; i++) {
            System.out.print(output[i] + " ");
        }
        System.out.println();
    }

    private static void dfs(int u) {
        for (int i = 1; i <= n; i++) {
            if (!flag[i]) {
                output[u] = i;
                if (u == n) {
                    print(output);
                    return;
                }
                flag[i] = true;
                dfs(u + 1);
                flag[i] = false;

            }
        }


    }
}
