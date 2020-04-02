package leetcode;

public class Leetcode1143 {
    //最长公共子序列
    //压缩空间的写法

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[] f = new int[m + 1];
        int result = 0;
        //记录左上角的值
        int last = 0;
        for (int i = 0; i < n; i++) {
            last = 0;
            for (int j = 0; j < m; j++) {
                int tmp = f[j + 1];
                if (text1.charAt(i) == text2.charAt(j)) {
                    f[j + 1] = Math.max(Math.max(last + 1, f[j]), f[j + 1]);
                } else {
                    f[j + 1] = Math.max(Math.max(last, f[j]), f[j + 1]);
                }
                result = Math.max(f[j + 1], result);
                System.out.println(f[j + 1]);
                last = tmp;
            }
            System.out.println();
        }

        return result;
    }
//    public int longestCommonSubsequence(String text1, String text2) {
//        int n = text1.length();
//        int m = text2.length();
//        int[][] f = new int[n + 1][m + 1];
//        int result = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if (text1.charAt(i) == text2.charAt(j)) {
//                    f[i + 1][j + 1] = Math.max(Math.max(f[i][j] + 1, f[i][j + 1]), f[i + 1][j]);
//                } else {
//                    f[i + 1][j + 1] = Math.max(Math.max(f[i][j], f[i][j + 1]), f[i + 1][j]);
//                }
//                result = Math.max(f[i + 1][j + 1], result);
//            }
//        }
//        return result;
//    }
}
