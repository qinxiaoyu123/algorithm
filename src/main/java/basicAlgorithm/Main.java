package basicAlgorithm;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N = 100010;
    static int[] f = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] line = reader.readLine().split("\\s+");
        int n = Integer.parseInt(line[0]);
        int idx = 0;
        for (String s : reader.readLine().split("\\s+")) {
            f[idx++] = Integer.parseInt(s);
        }
        quikSort(0,idx-1);
        for(int i  = 0;i<idx;i++){
            System.out.println(i+" ");
        }
    }

    private static void quikSort(int l, int r) {
        int x = f[(l+r)>>1], i = l -1, j= r +1;
        while(i<j){
            do{
                i++;
            } while(f[i]<x);
            do{j--;} while(f[j]>x);
            if(i<j) swap(l,r);
        }
        quikSort(l,j);
        quikSort(j+1,r);

    }

    private static void swap(int l, int r) {
        int tmp = f[l];
        f[l] = f[r];
        f[r] = tmp;
    }


}
