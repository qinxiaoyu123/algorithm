package leetcode;


import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class MovingCount {
    static int[] dx = {1, 0, 1};
    static int[] dy = {0, 1, 1};

    public static void main(String[] args) {
        MovingCount m = new MovingCount();
        System.out.println(m.movingCount(3,1,0));
    }
    public int movingCount(int m, int n, int k) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0, 0));
        boolean[][] flag = new boolean[m][n];
        flag[0][0] = true;
        int result = 0;
        if(k>=0) result++;
        while (!queue.isEmpty()) {
            Pair tmp = queue.poll();
            for (int i = 0; i < 3; i++) {
                int x = (int) tmp.getKey() + dx[i];
                int y = (int) tmp.getValue() + dy[i];
                if (0 <= x && x < m && 0 <= y && y < n) {
                    if (!flag[x][y] && (sum(x) + sum(y)) <= k) {
                        result++;
                        flag[x][y] = true;
                        queue.offer(new Pair(x, y));
                    }
                }
            }

        }
        return result;
    }

    private int sum(int min) {
        int result = 0;
        while (min >= 1) {
            result += min % 10;
            min = min / 10;
        }
        return result;
    }

}
