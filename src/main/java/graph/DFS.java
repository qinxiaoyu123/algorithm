package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DFS {
    static int N = 8;
    static int n ;
    static int []output = new int[N];
    static boolean []flag = new boolean[N];
    static int idx = -1;
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());

        dfs(1);
    }

    private static void dfs(int i) {
        while(flag[i]) i++;
        output[++idx] = i;
        flag[i] = true;
        if(idx == n-1){
            System.out.println(Arrays.toString(output));
        }
        dfs(i+1);
    }
}
