package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StonesCombined {
    static int N = 303;
    static int[] S = new int[N];//前缀和
    static int[][] f = new int[N][N];//状态

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int i = 0;
        for (String s : reader.readLine().split("\\s+")) {
            i++;
            S[i] = S[i - 1] + Integer.parseInt(s);
        }
        //区间长度为1的时候不需要合并
        for (int len = 2; len <= n; len++) {
            for(i = 1;i+len-1<=n;i++){
                int j = i+len-1;
                f[i][j] = 0x3f3f3f3f;
                for(int k = i;k<=i+len-2;k++){
                    f[i][j] = Math.min(f[i][j], f[i][k]+f[k+1][j]+S[j] - S[i-1]);
                }
            }
        }
        System.out.println(f[1][n]);
    }
}
