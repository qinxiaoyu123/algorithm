package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backpack01 {
    static int NN = 1010;
    static int V, N;
    static int[] v = new int[NN];
    static int[] w = new int[NN];
    static int[][] value = new int[NN][NN];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] line = reader.readLine().split("\\s+");
        N = Integer.parseInt(line[0]);
        V = Integer.parseInt(line[1]);
        for (int i = 1; i <= N; i++) {
            String[] list = reader.readLine().split("\\s+");
            v[i] = Integer.parseInt(list[0]);
            w[i] = Integer.parseInt(list[1]);
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= V; j++) {
                int tmp = j - v[i];
                if (tmp >= 0) {
                    value[i][j] = Math.max(value[i - 1][j], (value[i - 1][tmp] + w[i]));
                } else
                    value[i][j] = value[i - 1][j];
            }
        }
        // int res = 0;
        // for(int i = 1;i<=V;i++) res = Math.max(res, value[N][i]);
        // System.out.println(res);
        System.out.println(value[N][V]);
    }
}
