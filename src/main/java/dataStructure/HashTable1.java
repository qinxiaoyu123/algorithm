package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//开放寻址法
public class HashTable1 {
    static int N = 200003, nul = 1000000002;
    static int[] hash = new int[N];

    public static void main(String[] args) throws IOException {
        for(int i = 0; i< N ; i++) hash[i] = nul;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        while (n-- > 0) {
            String[] line1 = reader.readLine().split(" ");
            int x = Integer.parseInt(line1[1]);
            if (line1[0].equals("I")) {
                int k = find(x);
                hash[k] = x;
            }
            else {
                int k = find(x);
                if ( hash[k] == x) System.out.println("Yes");
                else System.out.println("No");
            }
        }
    }

    private static int find(int x) {
        int i = (x % N + N) % N;
        while(hash[i] != nul){
            if(hash[i] == x) return i;
            i++;
        }
        return i;
    }

}
