package leetcode;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main2 {
    static boolean[][] visited = new boolean[51][51];
    static Queue<Node> nodes = new LinkedList<Node>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        int idx = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                visited[i][j]= false;
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    nodes.offer(new Node(i, j));
                    visited[i][j] = true;
                    idx = 0;
                    while (!nodes.isEmpty()) {
                        idx++;
                        Node tmp = nodes.poll();
                        int x = tmp.x;
                        int y = tmp.y;
//                        System.out.println(x+" "+y);
                        for (int k = 0; k < 4; k++) {
                            int tmpX = x + dx[k];
                            int tmpY = y + dy[k];
                            if (tmpX >= 0 && tmpX < grid.length && tmpY >= 0 && tmpY < grid[0].length && !visited[tmpX][tmpY] && grid[tmpX][tmpY] == 1) {
                                visited[tmpX][tmpY] = true;
                                nodes.offer(new Node(tmpX, tmpY));
                            }
                        }
                    }

                }
                res = Math.max(res, idx);
            }
        }
        return res;
    }
    public static void main(String []args){
        int [][] grid = new int[][]{{1,1,0,1,1},{1,0,0,0,0},{0,0,0,0,1},{1,1,0,1,1}};
        System.out.println(maxAreaOfIsland(grid));
    }
}
