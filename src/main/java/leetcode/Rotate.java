package leetcode;

public class Rotate {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j1 = 0, j2 = n-1; j1 < j2; j1++, j2--) {
                int tmp = matrix[i][j1];
                matrix[i][j1] = matrix[i][j2];
                matrix[i][j2] = tmp;
            }
        }
    }
}
