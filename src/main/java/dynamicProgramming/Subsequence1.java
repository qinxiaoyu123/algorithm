package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Subsequence1 {
    static int N = 100010;
    static int []f = new int[N], g = new int[N];

    public static void main(String []args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int idx = 0;
        int n = Integer.parseInt(reader.readLine());
        for(String s: reader.readLine().split("\\s+")){
            g[idx++] = Integer.parseInt(s);
        }
        idx = 0;//指示f数组的索引范围
        f[0] = g[0];
        for(int i = 1;i<n;i++){
            //如果所有数都大于它，直接添加到最后，长度加1
            //否则找到大于等于他的最小值，用当前值替换这个值
            if(g[i]>f[idx]){
                f[++idx] = g[i];
                continue;
            }
            int l = 0, r = idx;
            int mid;
            while(l<r){
                mid = (l+r)>>1;
                if(f[mid]>= g[i]) r = mid;
                else l = mid+1;
            }
            f[l] = g[i];
        }
        System.out.println(idx+1);
    }
}
