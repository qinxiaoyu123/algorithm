package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dijkstra1 {
    static int N = 510;
    static int n;
    private static final int Max_length=0x3f3f3f3f;
    static int[][] g = new int[N][N];
    static int []dist = new int[N];
    static boolean []st = new boolean[N];
    public static void main(String []args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] line = reader.readLine().split("\\s");
        n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        for(int i =1;i<=n;i++){
            for(int j =1;j<=n;j++){
                g[i][j] = Max_length;
            }
        }
        //把i写成了n..
        for(int i = 1;i<=n;i++) {
            dist[i] = Max_length;
        }
        while(m-->0){
            String []line1 = reader.readLine().split("\\s");
            int a = Integer.parseInt(line1[0]), b = Integer.parseInt(line1[1]), c =  Integer.parseInt(line1[2]);
            g[a][b] = Math.min(c,g[a][b]);
        }
        bfs();
    }

    private static void bfs() {
        dist[1] = 0;
        for (int i = 1; i <= n; i++) {//控制循环次数,每一次循环确定一个最小的点
            int t = -1;
            for(int j = 1; j<=n;j++){
                if(!st[j] && (t ==-1 || dist[j]<dist[t])){
                    t = j;
                }
            }
            st[t] = true;
            for(int j = 1;j<=n;j++){
                dist[j] = Math.min(dist[j], dist[t]+g[t][j]);
            }
        }
        if(dist[n] == Max_length) System.out.println("-1");
        else System.out.println(dist[n]);
    }
}
