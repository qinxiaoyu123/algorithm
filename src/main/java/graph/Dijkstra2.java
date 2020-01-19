package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Node{
    int dis;
    int id;
    public Node(int dis, int id){
        this.dis = dis;
        this.id = id;
    }
    public int getDis() {
        return dis;
    }
    public int getId(){
        return id;
    }
    public void setDis(int dis){
        this.dis = dis;
    }
    public void setId(int id){
        this.id = id;
    }

}
public class Dijkstra2 {
    static  final int Max_length = 0x3f3f3f3f;
    static int n, idx;
    static int N = 100010;
    static int []h = new int[N], e = new int[N], ne = new int[N], w = new int[N];
    static int []dis = new int[N];
    static PriorityQueue<Node> que = new PriorityQueue<Node>(new Comparator<Node>() {
        public int compare(Node o1, Node o2) {
            return o1.getDis() - o2.getDis();
        }
    });
    static boolean[ ] st = new boolean[N];
    public static void main(String[]args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String []line = reader.readLine().split("\\s");
        n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        while(m-->0){
            String []line1 = reader.readLine().split("\\s");
            int a = Integer.parseInt(line1[0]), b = Integer.parseInt(line1[1]), c = Integer.parseInt(line1[2]);
            add(a,b,c);
        }
        bfs();
    }

    private static void bfs() {
        for(int i =1;i<=n;i++){
            dis[i] = Max_length;
        }
        dis[1] = 0;
        que.offer(new Node(0,1));
        while(que.size()>0){
            Node tmp = que.poll();
            int distance = tmp.getDis();
            int id = tmp.getId();
            if(st[id]) continue;
            st[id] = true;
            for(int i =h[id]; i!=0;i = ne[i]){
                int j = e[i];
                if(dis[j]>distance+w[i]) {
                    dis[j] = distance+w[i];
                    que.offer(new Node(dis[j],j));
                }
            }

        }
        if (dis[n] == 0x3f3f3f3f) System.out.println("-1");
        else System.out.println(dis[n]);

    }

    private static void add(int a, int b, int c) {
        idx++;
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx;

    }

}
