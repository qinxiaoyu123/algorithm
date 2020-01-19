package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Edge{
    private int a;
    private int b;
    private int z;

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getZ() {
        return z;
    }

    public Edge(int a, int b, int z) {
        this.a = a;
        this.b = b;
        this.z = z;

    }
}

public class BellmanFord {
    static int N = 10010;
    static Edge[] edges = new Edge[N];
    static int n,k,m;
    static int[]dis = new int[510];
    static int[]last = new int[510];
    public static void main(String[]args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] line = reader.readLine().split("\\s");
        n = Integer.parseInt(line[0]);
        k = Integer.parseInt(line[2]);
        m = Integer.parseInt(line[1]);
        for(int i =0;i<m;i++){
            String[] list = reader.readLine().split("\\s");
            int a = Integer.parseInt(list[0]), b = Integer.parseInt(list[1]), z = Integer.parseInt(list[2]);
            edges[i] = new Edge(a,b,z);
        }
        bellmanFord();
    }

    private static void bellmanFord() {
        Arrays.fill(dis,0x3f);
        dis[1] = 0;
        for (int i = 0; i < k; i ++ )
        {
            for(int j =0;j<n;j++){
                last[j] = dis[j];
            }
            for (int j = 0; j <m; j ++ )
            {
                Edge e = edges[j];
                dis[e.getB()] = Math.min(dis[e.getB()], last[e.getA()] + e.getZ());
            }
        }
        if (dis[n] > 0x3f3f3f3f / 2) System.out.println("impossible");
        else System.out.println(dis[n]);
    }

}
