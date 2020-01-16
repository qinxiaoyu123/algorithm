package graph;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.LinkedList;


public class NodeLayer {
    static java.util.Queue<Integer> que = new LinkedList<Integer>();
    static int N = 100010;
    static int M = 100010;
    static int[] g = new int[N];
    static int[] e = new int[2*N];
    static int[] ne = new int[2*N];
    static int n;
    static boolean[] flag = new boolean[2*N];
    static int[] dis = new int[N];
    static int idx;
    public static void main(String []args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] line = reader.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        while(m-->0){
            String[] line1 = reader.readLine().split(" ");
            int a  = Integer.parseInt(line1[0]), b = Integer.parseInt(line1[1]);

            idx++;
            e[idx] = b;
            ne[idx] = g[a];
            g[a] = idx;
//人家他妈是有向图！！！！
//            idx++;
//            e[idx] = a;
//            ne[idx] = g[b];
//            g[b] = idx;
        }
        que.offer(1);
        dis[1]= 0;
        flag[1] = true;
        bfs();
    }

    private static void bfs() {
        while(que.size()>0){
            Integer tmp = que.poll();
            for(int i = g[tmp]; i !=0;i=ne[i]){
                int value = e[i];
                if(flag[value]) continue;
                que.offer(value);
                flag[value] = true;
                dis[value] = dis[tmp]+1;
                if(value == n) {
                    System.out.println(dis[value]);
                    return;
                }
            }
        }
        System.out.println(-1);
    }
}
