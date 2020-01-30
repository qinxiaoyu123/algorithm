package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CompleteBackpackS1 {
    static int N = 1010;
    static int[] v = new int[N];
    static int[] w = new int[N];
    static int[] f = new int[N];
    static int[] s = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] line = reader.readLine().split("\\s+");
        int n = Integer.parseInt(line[0]), value = Integer.parseInt(line[1]);
        for (int i = 1; i <= n; i++) {
            String[] list = reader.readLine().split("\\s+");
            v[i] = Integer.parseInt(list[0]);
            w[i] = Integer.parseInt(list[1]);
            s[i] = Integer.parseInt(list[2]);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = value; j >= v[i]; j--) {
                for (int k = 0; k <= s[i]; k++) {
                    int tmp = k * v[i];
                    if (j < tmp) {
                        break;
                    }
                    f[j] = Math.max(f[j], f[j - tmp] + k * w[i]);
                }
            }
        }
        System.out.println(f[value]);
    }
}
