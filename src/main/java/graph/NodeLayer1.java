package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NodeLayer1 {
    static int N = 100010;
    static int n;
    static int idx = 0 ;
    static int []g = new int[N];
    static int []ne = new int[N];
    static int []e = new int[N];
    static int []dis = new int[N];
    static Queue<Integer> que = new LinkedList<Integer>();
    public static void main(String[]args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] line = reader.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        // for(int i :g) i = -1;
        Arrays.fill(g,-1);
        while(m-->0){
            String[] line1 = reader.readLine().split(" ");
            int a  = Integer.parseInt(line1[0]), b = Integer.parseInt(line1[1]);
            add(a,b);
//            add(b,a);
        }

        bfs();
    }

    private static void bfs() {
        Arrays.fill(dis,-1);
        // for(int i :dis) i = -1;
        que.offer(1);
        dis[1]= 0;
        while(que.size()>0){
            int tmp = que.poll().intValue();
            for(int i = g[tmp]; i!= -1; i = ne[i]){
                int j = e[i];
                if(dis[j] == -1){
                    dis[j] = dis[tmp] +1;
                    que.offer(j);
                }
            }

        }
        System.out.println(dis[n]);
    }

    private static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = g[a];
        g[a] = idx;
        idx++;
    }
}
