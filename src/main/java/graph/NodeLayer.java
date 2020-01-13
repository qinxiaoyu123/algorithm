package graph;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import dataStructure.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
    static HashMap<Integer, Integer> dis = new LinkedHashMap<Integer, Integer>();
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

            idx++;
            e[idx] = a;
            ne[idx] = g[b];
            g[b] = idx;
        }
        que.offer(1);
        dis.put(1,0);
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
                dis.put(value,dis.get(tmp)+1);
//                if(value == n) {
//                    System.out.println(dis.get(value));
//                    return;
//                }
            }
        }
        if(flag[n]) System.out.println(dis.get(n));
        else System.out.println(-1);
    }
}
