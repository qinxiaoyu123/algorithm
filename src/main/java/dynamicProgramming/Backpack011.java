package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backpack011 {
    static int NN = 1010;
    static int V, N;
    static int[] v = new int[NN];
    static int[] w = new int[NN];
    static int[] value = new int[NN];

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
            for (int j = V; j >= v[i]; j--) {
                value[j] = Math.max(value[j], (value[j-v[i]] + w[i]));
            }
        }
        System.out.println(value[V]);
    }
}
