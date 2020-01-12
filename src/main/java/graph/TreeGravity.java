package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class TreeGravity {
    static int N = 100010;
    static int[] g = new int[N];
    static int []ne = new int[2*N];
    static int []e = new int[2*N];
    static boolean []flag = new boolean[N];
    static int idx = 0;
    static int ans = N+1;
    static int n;
    public static void main(String[]args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        int tmp = n-1;
        while(tmp-->0){
            String []line = reader.readLine().split(" ");
            int a  = Integer.parseInt(line[0]);
            int b  = Integer.parseInt(line[1]);

            idx++;
            e[idx] = b;
            ne[idx] = g[a];
            g[a] = idx;

            idx++;
            e[idx] = a;
            ne[idx] = g[b];
            g[b] = idx;

        }

        dfs(1);
        System.out.println(ans);
    }

    private static int dfs(int id) {
        int count = 1, mi = 0;

        flag[id] = true;

        for(int i = g[id];i!=0;i = ne[i]){

            if(!flag[e[i]]){
                int tmp = dfs(e[i]);
                count += tmp;
                mi  = max(mi,tmp);
            }
        }
        mi = max(mi,n-count);
        ans = min(ans,mi);
        return count;

    }
}
