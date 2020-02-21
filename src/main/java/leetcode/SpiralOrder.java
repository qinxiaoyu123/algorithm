package leetcode;

import java.util.*;

public class SpiralOrder {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public List<Integer> spiralOrder(int[][] matrix) {
        int x = 0, y = 0;
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) return result;
        boolean[][] flag = new boolean[matrix.length][matrix[0].length];
        int n = matrix.length * matrix[0].length;
        int idx = 1;
        int direction = 0;
        result.add(matrix[x][y]);
        flag[x][y] = true;
        while (idx < n) {
            int tmpX = x + dx[direction];
            int tmpY = y + dy[direction];
            if (tmpX < 0 || tmpX >= matrix.length || tmpY < 0 || tmpY >= matrix[0].length || flag[tmpX][tmpY]) {
                direction = (direction + 1) % 4;
            } else {
                x = tmpX;
                y = tmpY;
                idx++;
                result.add(matrix[x][y]);
                flag[x][y] = true;
            }

        }
        return result;
    }
}
