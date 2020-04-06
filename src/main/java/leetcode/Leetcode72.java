package leetcode;

public class Leetcode72 {
    //编辑距离
    public static void main(String[] args) {
        Leetcode72 l = new Leetcode72();
        l.minDistance("horse", "ros");
    }
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int f[][] = new int[m + 1][n + 1];
        f[0][0] = 0;
        for (int j = 1; j <= n; j++) {
            f[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            f[i][0] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1];
                } else {
                    f[i][j] = Math.min(Math.min(f[i - 1][j], f[i][j - 1]), f[i - 1][j - 1]) + 1;
                }
            }
        }
        return f[m][n];
    }
}
