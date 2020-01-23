package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeCollection {
    static int n = 100010;
    static int []p = new int[100010];
    public static void main(String []args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String []line = reader.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        for( int i = 1; i<=n;i++) p[i] = i;
        while(m-->0){
            String []line1 = reader.readLine().split(" ");
            int a = Integer.parseInt(line1[1]);
            int b = Integer.parseInt(line1[2]);
            if(line1[0].equals("M")) p[find(a)] = find(b);
            else{
                if(find(a) == find(b)) System.out.println("Yes");
                else System.out.println("No");
            }
        }
    }

    private static int find(int b) {
        if (p[b] != b) p[b] = find(p[b]);
        return p[b];
    }
}
