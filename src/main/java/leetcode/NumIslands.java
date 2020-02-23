package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class NumIslands {
    class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] visited;
    static int count = 0;
    static int N;
    static int M;
    Queue<Node> queues = new LinkedList<>();

    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        queues.clear();
        count = 0;
        N = grid.length;
        M = grid[0].length;
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if ((grid[i][j] == '1') && !visited[i][j]) {
                    queues.offer(new Node(i, j));
                    visited[i][j] = true;
                    bfs(grid);
                    count++;
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid) {
        while (queues.size() != 0) {
            Node tmp = queues.poll();
            int xTmp = tmp.x;
            int yTmp = tmp.y;
            for (int i = 0; i < 4; i++) {
                int xx = xTmp + dx[i];
                int yy = yTmp + dy[i];
                if (0 <= xx && xx < N && 0 <= yy && yy < M && grid[xx][yy] == '1' && !visited[xx][yy]) {
                    queues.offer(new Node(xx, yy));
                    visited[xx][yy] = true;
                }
            }
        }
    }
}
