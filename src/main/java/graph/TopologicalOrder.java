package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class TopologicalOrder {
    static int N = 100010;
    static int idx = 0;
    static int id = 0;
    static int n;
    static int[] g = new int[100010];
    static int[] e = new int[100010];
    static int[] ne = new int[100010];
    static int[] in = new int[100010];
    static int[] arry = new int[100010];
    static int count = 0;
    static Queue<Integer> que = new LinkedList<Integer>();
    public static void main(String []args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String []line = reader.readLine().split("\\s");
        n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        while (m-->0){
            String []line1 = reader.readLine().split("\\s");
            int a = Integer.parseInt(line1[0]), b = Integer.parseInt(line1[1]);
            add(a,b);
        }
        dfs();
    }

    private static void dfs() {
        for(int i =1;i<=n;i++){
            if(in[i]==0){
                que.offer(i);
                arry[count] = i;
                // System.out.println(i);
                count++;
            }
        }
        while(que.size()>0){
            int tmp = que.poll();
            for(int i = g[tmp]; i != 0;i = ne[i]){
                in[e[i]] --;
                // System.out.println("e"+e[i]);
                // System.out.println("in"+in[e[i]]);
                if(in[e[i]] == 0) {
                    que.offer(e[i]);
                    arry[count++] = e[i];
                    // System.out.println(e[i]);
                }
            }
        }


        if(count == n){
            for(int i = 0;i<n;i++){
                System.out.print(arry[i]+" ");
            }
        }
        else System.out.println("-1");
    }

    private static void add(int a, int b) {
        idx++;
        e[idx] = b;
        ne[idx] = g[a];
        g[a] = idx;
        in[b] ++;
    }
}
