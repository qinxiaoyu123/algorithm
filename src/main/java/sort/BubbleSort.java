package sort;

import java.util.Arrays;

public class BubbleSort {
    public int[] bubbleSort(int[] arg) {
        int n = arg.length;
        if (n == 0 || n == 1) return arg;
        //n-1次循环，每次循环把最大的数放在最右边
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arg[j] > arg[j + 1]) {
                    int tmp = arg[j];
                    arg[j] = arg[j + 1];
                    arg[j + 1] = tmp;
                }
            }
        }
        return arg;
    }

    public static void main(String[] args) {
//        int []a = {3,2,4,5,1};
        int[] a = {3, 2};
        System.out.println(Arrays.toString(new BubbleSort().bubbleSort(a)));
    }
}
