package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Subsequence {
    static int N = 1010;
    static int []f = new int[N], g = new int[N];
    public static void main(String []args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int idx = 0;
        for(String s : reader.readLine().split("\\s+")){
            g[idx++] = Integer.parseInt(s);
        }
        Arrays.fill(f,1);
        int mmax = 0;
        for(int i = 1; i<n;i++){
            for(int j = 0;j<i;j++){
                if(g[j]<g[i]){
                    f[i] = Math.max(f[i], f[j]+1);
                }
            }
            mmax = Math.max(mmax, f[i]);
        }
        System.out.println(mmax);
    }

}
