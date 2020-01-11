package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Pairr {
    private int x;
    private int y;

    Pairr(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class Maze {
    static int[][] g = new int[101][101];
    static int[][] d = new int[101][101];
    static Pairr p = new Pairr(0, 0);
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n;
    static int m;
    static Queue<Pairr> que = new LinkedList<Pairr>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] line = reader.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                d[i][j] = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            String[] line1 = reader.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                g[i][j] = Integer.parseInt(line1[j]);
            }
        }
        g[0][0] = 1;
        que.offer(p);
        dfs(p);

    }

    private static void dfs(Pairr p) {
        while (que.size() > 0) {
            Pairr px = que.poll();
            for (int i = 0; i < 4; i++) {
//            System.out.println("aaa");

                int x = px.getX() + dx[i];
                int y = px.getY() + dy[i];
//            System.out.println(x+" "+y);
                if (x >= 0 && x < n && y >= 0 && y < m && g[x][y] == 0) {
                    d[x][y] = d[px.getX()][px.getY()] + 1;
//                    System.out.println(x+" "+y);
//                    System.out.println(d[x][y]);
                    g[x][y] = 1;
                    if (x == n - 1 && y == m - 1) {
//                        System.out.println(x+" "+y);
                        System.out.println(d[x][y]);
                        return;
                    } else {
                        Pairr pp = new Pairr(x, y);
                        que.offer(pp);
                    }
                }
            }
        }

    }
}
