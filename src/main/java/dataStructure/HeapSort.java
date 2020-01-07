package dataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class HeapSort {
    static int []h = new int[100010];
    static int size = 0;
    public static void main (String[]args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String []line = reader.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        String []line1 = reader.readLine().split(" ");
        for(int i = 1; i<=n; i++) h[i] = Integer.parseInt(line1[i-1]);
        size = n;
        for (int i = n/2; i> 0;i--) down(i);
        while(m-->0){
            System.out.print(h[1]+" ");
            h[1] = h[size];
            size --;
            down(1);
        }

    }

    private static void down(int i) {
        int t = i;
        if( 2*i<=size && h[2*i] < h[t]) t = 2*i;
        if( 2*i+1 <= size && h[2*i+1] < h[t]) t = 2*i+1;
        if(i!=t) {
            int tmp = h[t];
            h[t] = h[i];
            h[i] = tmp;
            down(t);
        }
    }
}
