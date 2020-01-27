package basicAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N = 100010;
    static int[] p = new int[N];
    static int[] count = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] list = reader.readLine().split("\\s");
        int n = Integer.parseInt(list[0]), m = Integer.parseInt(list[1]);
        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }
        Arrays.fill(count,1);
        while (m-- > 0) {
            String[] line = reader.readLine().split("\\s");
            if(line[0].equals("C")){
                int a = Integer.parseInt(line[1]), b = Integer.parseInt(line[2]);
                int pa = find(a);
                int pb = find(b);
                if(pa != pb){
                    p[pa] = pb;
                    count[pb] += count[pa];
                }
            }
            else if(line[0].equals("Q1")){
                int a = Integer.parseInt(line[1]), b = Integer.parseInt(line[2]);
                int pa = find(a);
                int pb = find(b);
                if(pa != pb){
                    System.out.println("No");
                }
                else{
                    System.out.println("Yes");
                }
            }
            else{
                int a = Integer.parseInt(line[1]);
                System.out.println(count[find(a)]);
            }
        }
    }

    private static int find(int a) {
        if(p[a] != a) p[a] = find(p[a]);
        return p[a];
    }


}
