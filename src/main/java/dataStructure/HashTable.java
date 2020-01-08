package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HashTable {
    static int N = 100003, idx;
    static int[] hash = new int[N];
    static int[] e = new int[N];
    static int[] ne = new int[N];

    public static void main(String[] args) throws IOException {
//        for(int i = 0; i<=N;i++) hash[i] = -1;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        while (n-- > 0) {
            String[] line1 = reader.readLine().split(" ");
            int x = Integer.parseInt(line1[1]);
            if (line1[0].equals("I")) insert(x);
            else {
                if (find(x)) System.out.println("Yes");
                else System.out.println("No");
            }
        }
    }

    private static boolean find(int x) {
        int i = (x % N + N) % N;
        if(hash[i] == 0) return false;
        int  t = hash[i];
        do {
            if(e[t] == x) return true;
            t = ne[t];
        }while(t != 0);
        return false;
    }

    private static void insert(int x) {
        int i = (x % N + N) % N;
        idx++;
        e[idx] = x;
        ne[idx] = hash[i];
        hash[i] = idx;
    }
}
