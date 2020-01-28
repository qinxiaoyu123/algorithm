package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HungaryAlgorithm {
    static int N = 510;
    static int M = 100010;
    static int[]g = new int[N], match = new int[N];
    static int idx;
    static int res;
    static int []e = new int[M], ne = new int[M];
    static boolean[]st = new boolean[N];
    public static void main(String []args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String []line = reader.readLine().split("\\s+");
        int n1 = Integer.parseInt(line[0]), n2 = Integer.parseInt(line[1]), m = Integer.parseInt(line[2]);
        while(m-->0){
            String []list = reader.readLine().split("\\s+");
            int a = Integer.parseInt(list[0]), b = Integer.parseInt(list[1]);
            add(a,b);
        }
        for(int i = 1;i<=n1;i++){
            Arrays.fill(st, false);
            if(find(i)) res++;
        }
        System.out.println(res);
    }

    private static boolean find(int id) {
        for(int i = g[id]; i != 0 ; i = ne[i]){
            int tmp = e[i];
            if(!st[tmp]){
                st[tmp] = true;
                if(match[tmp] == 0|| find(match[tmp])){
                    match[tmp] = id;
                    return true;
                }
            }
        }
        return false;
    }



    private static void add(int a, int b) {
        idx++;
        e[idx] = b;
        ne[idx] = g[a];
        g[a] = idx;
    }
}

