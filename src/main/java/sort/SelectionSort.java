package sort;

import java.util.Arrays;

public class SelectionSort {
    public int[] selectionSort(int[] arg) {
        int n = arg.length;
        if(n == 0||n==1) return arg;
        for (int i = 0; i < n - 1; i++) {
            int midIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arg[j] < arg[midIndex]) {
                    midIndex = j;
                }
            }
            if (midIndex != i) {
                int tmp = arg[midIndex];
                arg[midIndex] = arg[i];
                arg[i] = tmp;
            }
        }
        return arg;
    }

    public static void main(String[] args) {
        int []a = {3,2,5,1};
        System.out.println(Arrays.toString(new SelectionSort().selectionSort(a)));

    }
}
