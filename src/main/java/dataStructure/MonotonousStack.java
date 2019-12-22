package dataStructure;

import java.util.ArrayList;
import java.util.Scanner;

public class MonotonousStack {
    static int m = 100010;
    static int []arry = new int[m];
    static int tt = -1;
    public static void main(String []args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        while(n-->0){
            int tmp = input.nextInt();
            while(tt>=0 && arry[tt]>=tmp) tt--;
//            System.out.println("tt"+tt);
            if(tt>=0) System.out.print(arry[tt]+" ");
            else System.out.print("-1 ");
            arry[++tt] = tmp;
        }
    }
}
