package dataStructure;

import jdk.nashorn.internal.runtime.regexp.joni.exception.SyntaxException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FoodChain {
    static int[] pe = new int[50010];
    static int[] len = new int[50010];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] line = reader.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int K = Integer.parseInt(line[1]);
        for (int i = 1; i <= N; i++) {
            pe[i] = i;
            len[i] = 0;
        }
        int size = 0;
        while (K-- > 0) {
            String[] line1 = reader.readLine().split(" ");
            int a = Integer.parseInt(line1[1]);
            int b = Integer.parseInt(line1[2]);
            if (a > N || b > N) {
                size++;
                continue;
            }
            if (line1[0].equals("1")) {
                int pa = find(a), pb = find(b);
                if (pa != pb) {
                    len[pa] = len[b] - len[a];
                    pe[pa] = pb;
                } else {
                    if ((len[a] - len[b]) % 3 != 0) size++;
                }
            } else {
                if (a == b) {
                    size++;
                    continue;
                } else {
                    int pa = find(a), pb = find(b);
                    if (pa != pb) {
                        len[pa] = len[b] - len[a] + 1;
                        pe[pa] = pb;
                    } else {
                        if ((len[a] - len[b] - 1) % 3 != 0) size++;
                    }
                }
            }
        }
        System.out.println(size);
    }

    private static int find(int a) {
        int i = pe[a];
        if (pe[a] != a) pe[a] = find(pe[a]);
        len[a] = len[a]+len[i];
        return pe[a];
    }
}
