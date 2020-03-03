package sort;

import java.util.Arrays;

public class HeapSort {
    static int[] h = new int[10010];
    static int size;

    public static void main(String[] args) {
        int[] a = {4, 5, 1, 3, 2};
        int n = a.length;
        for(int i = 0;i<n;i++){
            h[i+1] = a[i];
        }
        System.out.println(Arrays.toString(h));
        size = n;
        for (int i = n / 2; i >= 1; i--) {
            down(i);
            System.out.println(Arrays.toString(h));
        }
        int k = 3;


        while(k-->0){
            //不能从0开始
            System.out.println(Arrays.toString(h));
            System.out.println(h[1]);
            h[1]=h[size--];
            down(1);

        }
    }

    private static void down( int i) {

        int minIndex = i;
        if (2 * i <= size && h[2 * i] < h[minIndex]) {
            minIndex = 2 * i;
        }
        if (2 * i + 1 <= size && h[2 * i + 1] < h[minIndex]) {
            minIndex = 2 * i + 1;
        }
        if (minIndex != i) {
            int tmp = h[minIndex];
            h[minIndex] = h[i];
            h[i] = tmp;
            down(minIndex);
        }
    }
}
