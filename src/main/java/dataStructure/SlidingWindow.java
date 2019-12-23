package dataStructure;

import java.io.*;
import java.util.Scanner;

public class SlidingWindow {
    static int m = 1000010;
    static int []aa = new int [m];
    static int []qq = new int [m];
    public static void main(String []args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = reader.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);
        String[] line1 = reader.readLine().split(" ");
        for(int i = 0; i<n;i++) aa[i] = Integer.parseInt(line1[i]);
        int hh = 0, tt = -1;
        for(int i = 0; i<n;i++) {
            if(hh<=tt && i-k+1> qq[hh]) hh++;
            while(hh<=tt && aa[qq[tt]]>=aa[i]) tt--;
            qq[++tt] = i;
            if(i >= k-1) log.write(aa[qq[hh]]+" ");
        }
        log.write("\n");
        hh = 0; tt = -1;
        for(int i = 0; i<n;i++) {
            if(hh<=tt && i-k+1> qq[hh]) hh++;
            while(hh<=tt && aa[qq[tt]]<=aa[i]) tt--;
            qq[++tt] = i;
            if(i >= k-1) log.write(aa[qq[hh]]+" ");
        }
        log.flush();
        log.close();
        reader.close();
    }
}
