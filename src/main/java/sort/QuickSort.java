package sort;

import java.util.Arrays;

public class QuickSort {
    public void quickSort(int[] arg, int l, int r) {
        if(l>=r) return;
        int mid = (l + r) >> 1;
        int x = arg[mid];
        int i = l;
        int j = r;
        while (i < j) {
            while (arg[i] < x) i++;
            while (arg[j] > x) j--;
            if (i != j) {
                int tmp = arg[i];
                arg[i] = arg[j];
                arg[j] = tmp;
                i++;
                j--;
            }
        }
        quickSort(arg, l, j);
        quickSort(arg, j+1, r);
    }

    public static void main(String[] args) {
        int[] a = {3, 2, 4, 1, 5};
        new QuickSort().quickSort(a, 0, 4);
        System.out.println(Arrays.toString(a));

    }
}
