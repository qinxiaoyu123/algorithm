package leetcode;

public class LeetCode5 {
    public static void main(String[] args) {
        LeetCode5 l = new LeetCode5();

        System.out.println(l.longestPalindrome("babad"));
    }

    //动态规划
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0) return s;
        boolean[][] p = new boolean[n][n];
        int result = 1;
        int start = 0;
        int end = 0;
        //初始化长度为1的字符串
        for (int i = 0; i < n; i++) {
            p[i][i] = true;
        }
        //初始化长度为2的字符串
        for (int i = 0; i < n - 1; i++) {
            int j = i + 1;
            if (s.charAt(i) == s.charAt(j)) {
                p[i][j] = true;
                if(j-i+1>result){
                    result = j-i+1;
                    start = i;
                    end = j;
                }
            }
        }
        //状态转移方程
        for (int j = 2; j < n; j++) {
            for (int i = 0; i < n; i++) {
                if (i + j >= n) break;
                p[i][i+j] = p[i + 1][i+j - 1] && s.charAt(i) == s.charAt(i+j);
                if(p[i][i+j]){
                    if(j+1>result){
                        result = j+1;
                        start = i;
                        end = i+j;
                    }
                }
            }
        }
        return s.substring(start, end+1);
    }

    //方法四：中心扩展算法
    //事实上，只需使用恒定的空间，我们就可以在 O(n2)O(n^2)O(n2) 的时间内解决这个问题。
    //我们观察到回文中心的两侧互为镜像。因此，回文可以从它的中心展开，并且只有 2n−12n - 12n−1 个这样的中心。
    //你可能会问，为什么会是 2n−12n - 12n−1 个，而不是 nnn 个中心？原因在于所含字母数为偶数的回文的中心可以处于两字母之间（例如 “abba”\textrm{“abba”}“abba” 的中心在两个 ‘b’\textrm{‘b’}‘b’ 之间）。
//    public String longestPalindrome(String s) {
//        int n = s.length();
//        if (n == 0) return s;
//        int start = 0;
//        int end = 0;
//        for (int i = 0; i < n; i++) {
//            int len1 = findSubString(i, i, s);
//            int len2 = findSubString(i, i + 1, s);
//            len1 = Math.max(len1, len2);
//            if (len1 > end - start + 1) {
//                start = i - (len1 - 1) / 2;
//                end = i + len1 / 2;
//            }
//        }
//        return s.substring(start, end + 1);
//    }
//
//    private int findSubString(int i, int i1, String s) {
//        int len = 1;
//        while (i >= 0 && i < s.length() && i1 >= 0 && i1 < s.length()) {
//            if (s.charAt(i) == s.charAt(i1)) {
//                len = i1 - i + 1;
//                i--;
//                i1++;
//            } else break;
//        }
//        return len;
//    }


    //超时
//    public String longestPalindrome(String s) {
//        int n = s.length();
//        if (n == 0) return s;
//        int count = 1;
//        int k1 = 0, k2 = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                int l = i, r = j;
//                boolean flag = true;
//                while (l <= r) {
//                    if (s.charAt(l) == s.charAt(r)) {
//                        l++;
//                        r--;
//                    } else {
//                        flag = false;
//                        break;
//                    }
//                }
//                if (flag) {
//                    if (j - i + 1 > count) {
//                        count = j - i + 1;
//                        k1 = i;
//                        k2 = j;
//                    }
//                }
//            }
//        }
//        return s.substring(k1, k2 + 1);
//    }
}
