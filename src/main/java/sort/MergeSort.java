package sort;

import java.util.Arrays;

public class MergeSort {
    static int N = 10010;
    static int[] tmp = new int[N];

    public void mergeSort(int[] a, int l, int r) {
        if (l >= r) return;
        int mid = (l + r) >> 1;
        //先递归排序两个子序列
        mergeSort(a, l, mid);
        mergeSort(a, mid + 1, r);
        int i1 = l, i2 = mid + 1;
        int k = 0;
        //进行合并
        while (i1 <= mid && i2 <= r) {
            if (a[i1] <= a[i2]) {
                tmp[k++] = a[i1++];
            } else {
                tmp[k++] = a[i2++];
            }
        }
        while (i1 <= mid) tmp[k++] = a[i1++];
        while (i2 <= r) tmp[k++] = a[i2++];
        k = 0;
        for (int i = l; i <= r; i++) {
            a[i] = tmp[k++];
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 2};
        new MergeSort().mergeSort(a, 0, 1);
        System.out.println(Arrays.toString(a));
    }
}
