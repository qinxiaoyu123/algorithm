package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuickSort {
    static int [] arry = new int[100010];
    public static void main(String []args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int i = 0;
        for(String s: reader.readLine().split("\\s+")){
            arry[i++] = Integer.parseInt(s);
        }
        quickSort(0,n-1);
        for(i = 0;i<n;i++){
            System.out.print(arry[i]+" ");
        }
    }

    private static void quickSort(int l, int r) {
        if(r<=l) return;
        int  x = arry[(l+r)>>1];
        int i = l-1;
        int j = r+1;
        while(i<j){
            do i++; while(arry[i]<x);
            do j--; while(arry[j]>x);
            if(i<j){
                swap(i,j);
            }
        }
        quickSort(l,j);
        quickSort(j+1,r);
    }

    private static void swap(int i, int j) {
        int tmp = arry[j];
        arry[j] = arry[i];
        arry[i] = tmp;
    }
}
