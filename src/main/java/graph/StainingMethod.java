package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StainingMethod {
    static int N = 100010;
    static int M = 200010;
    static int[]g = new int[N], color = new int[N];
    static int []e = new int[M], ne = new int[M];

    static int idx = 0;
    static boolean flag = true;
    public static void main(String []args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String []line = reader.readLine().split("\\s+");
        int n = Integer.parseInt(line[0]), m = Integer.parseInt(line[1]);
        while(m-->0){
            String []list = reader.readLine().split("\\s+");
            int a = Integer.parseInt(list[0]), b = Integer.parseInt(list[1]);
            //无向图添加两次边
            add(a,b);
            add(b,a);
        }
        for(int i = 1;i<=n;i++){
            if(color[i]==0){
                if(!dfs(i,1)) {
                    flag = false;
                    break;
                }
            }
        }
        if(flag) System.out.println("Yes");
        else System.out.println("No");
    }

    private static boolean dfs(int id, int colour) {
        if(color[id]==0){
            color[id]=colour;
            for(int i = g[id]; i!= 0;i = ne[i]){
                int tmp = e[i];
                if(!dfs(tmp,3-colour)) return false;
            }
        }
        if (color[id]!=colour) return false;
        return true;
    }

    private static void add(int a, int b) {
        idx++;
        e[idx] = b;
        ne[idx] = g[a];
        g[a] = idx;
    }
}
