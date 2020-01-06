package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConnectedPiece {
    static int []pe = new int[100010];
    static int []count = new int[100010];
    public static void main(String []args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String []line = reader.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        for(int i =1;i<=n;i++){
            pe[i] = i;
            count[i] = 1;
        }
        while(m-->0){
            String []line1 = reader.readLine().split(" ");
            int a = Integer.parseInt(line1[1]);

            if(line1[0].equals("C")) {
                int b = Integer.parseInt(line1[2]);
                int pa = find(a);
                int pb = find(b);
                if(pa != pb){
                    count[pb] += count[pa];
                    pe[pa] = pb;
                }
            }
            else{
                if(line1[0].equals("Q1")){
                    int b = Integer.parseInt(line1[2]);
                    if(find(a)==find(b)) System.out.println("Yes");
                    else System.out.println("No");
                }
                else{
                    System.out.println(count[find(a)]);
                }
            }
        }

    }
    static int find(int x){
        if(pe[x] != x) pe[x] = find(pe[x]);
        return pe[x];
    }
}
