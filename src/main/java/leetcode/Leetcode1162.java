package leetcode;


import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode1162 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Pair> queue = new LinkedList<>();

    public int maxDistance(int[][] grid) {
        boolean[][] flag = new boolean[grid.length][grid[0].length];

        int count = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {

                    for (int k = 0; k < flag.length; k++) {
                        for (int k1 = 0; k1 < flag[k].length; k1++) {
                            flag[k][k1] = false;
                        }
                    }
                    queue.clear();

                    queue.offer(new Pair(i, j));
                    flag[i][j] = true;
                    Pair tmp = bfs(grid, flag);
                    if(tmp == null) return -1;
                    int diffX = (int) tmp.getKey() - i;
                    diffX = diffX >= 0 ? diffX : -diffX;
                    int diffY = (int) tmp.getValue() - j;
                    diffY = diffY >= 0 ? diffY : -diffY;
                    count = Math.max(count, diffX + diffY);
                }
            }
        }
        return count;
    }

    private Pair bfs(int[][] grid, boolean[][] flag) {
        while (!queue.isEmpty()) {
            Pair tmp = queue.poll();
            int tmpX = (int) tmp.getKey();
            int tmpY = (int) tmp.getValue();
            for (int i = 0; i < 4; i++) {
                int x = tmpX + dx[i];
                int y = tmpY + dy[i];
                if (0 <= x && x < grid.length && 0 <= y && y < grid[0].length) {
                    if (grid[x][y] == 0 && !flag[x][y]) {
                        queue.add(new Pair(x, y));
                        flag[x][y] = true;
                    } else if (grid[x][y] == 1) {
                        return new Pair(x, y);
                    }
                }
            }
        }
        return null;
    }
}
