package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Spf1 {
    static int N = 10010;
    static int idx;
    static int n;
    static int[]g = new int[N], e = new int[N], ne = new int[N], w = new int[N], dist = new int[N];
    static Queue<Integer> que = new LinkedList<>() ;
    static boolean[] st = new boolean[N];
    public static void main(String []args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String []line = reader.readLine().split("\\s");
        n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        while(m-->0){
            String []list = reader.readLine().split("\\s");
            int a = Integer.parseInt(list[0]);
            int b = Integer.parseInt(list[1]);
            int c = Integer.parseInt(list[2]);
            add(a,b,c);
        }
        int t = spf();
        if(t == 0x3f3f3f) System.out.println("impossible");
        else System.out.println(t);
    }

    private static int spf() {
        Arrays.fill(dist,0x3f3f3f);
        dist[1] = 0;
        que.offer(1);
        st[1] = true;
        while(que.size()>0){
            int tmp = que.poll();
            st[tmp] = false;
            for(int i = g[tmp]; i != 0;i = ne[i]){
                int j = e[i];
                if(dist[j] > dist[tmp]+w[i]){
                    dist[j] = dist[tmp]+w[i];
                    if(!st[j]){
                        que.offer(j);
                        st[j] = true;
                    }
                }
            }
        }
        return dist[n];

    }

    private static void add(int a, int b, int c) {
        idx++;
        e[idx] = b;
        w[idx] = c;
        ne[idx] = g[a];
        g[a] = idx;
    }
}
