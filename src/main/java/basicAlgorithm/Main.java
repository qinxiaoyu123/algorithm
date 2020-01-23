package basicAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N = 100010;
    static int [] p = new int[N];
    public static void main(String []args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String [] line = reader.readLine().split("\\s");
        int n = Integer.parseInt(line[0]), m = Integer.parseInt(line[1]);
        for(int i = 1;i<=n;i++){
            p[i] = i;
        }
        while(m-->0){
            String []list = reader.readLine().split("\\s");
            int a = Integer.parseInt(list[1]), b = Integer.parseInt(list[2]);
            int pa = find(a), pb = find(b);
            if(list[0].equals("M")){
                if( pa != pb ) p[pa] = pb;
            }
            else{
                if( pa == pb ) {
                    System.out.println("Yes");
                }
                else{
                    System.out.println("No");
                }
            }
        }
    }

    private static int find(int a) {
        if(p[a] != a) p[a] = find(p[a]);
        return p[a];
    }
}
