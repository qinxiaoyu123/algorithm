package dataStructure;

import java.io.*;
import java.nio.Buffer;

public class KMP {
    static int N = 10010, M = 100010;
    static char []P = new char[N];
    static char []S = new char[M];
    static int[] ne = new int[N];
    public static void main(String []args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        String pStr = reader.readLine();
        for(int i = 1; i<= n;i++) P[i] = pStr.charAt(i-1);
        int m = Integer.parseInt(reader.readLine());
        String sStr = reader.readLine();
        for(int i = 1; i<= m;i++) S[i] = sStr.charAt(i-1);

        for (int i = 2, j = 0; i <= n; i++) {   // i = 1的时候只有一个元素, 最长前缀的长度为 0
            while (j != 0 && P[i] != P[j + 1]) j = ne[j];
            if (P[i] == P[j + 1]) j++;
            ne[i] = j;
        }

        // kmp匹配过程
        // i指向 s将要匹配的位置, j指向已经匹配模板串已经匹配成功的位置
        for (int i = 1, j = 0; i <= m; i++) {
            while (j != 0 && S[i] != P[j + 1]) j = ne[j];  // 进行 next跳转
            // 继续进行匹配, 如果此时模板串的字符和被匹配字符串的字符相等, 继续向下进行匹配++
            if (S[i] == P[j + 1]) j++;
            // 如果匹配成功
            if (j == n) {
                log.write(i - n + " "); // 将 s串中起点的位置写入
                j = ne[j];    // 进行 next跳转
            }
        }
        log.flush();    // 关闭输入输出流
        reader.close();
        log.close();
    }

}



















