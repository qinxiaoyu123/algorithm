package sort;

import java.util.Arrays;

public class InsertionSort {
    public int[] insertionSort(int[] arg) {
        int n = arg.length;
        if (n == 0 || n == 1) return arg;
        for (int i = 1; i < n; i++) {
            //这里0-i已经排序好
            //循环赋值时会覆盖，所以这里必须存arg[i]的值，不能存索引i
            int current = arg[i];
            int preIndex = i - 1;
            while (preIndex >= 0 && current < arg[preIndex]) {
                arg[preIndex + 1] = arg[preIndex];
                preIndex--;
            }
            arg[preIndex + 1] = current;
        }
        return arg;
    }

    public static void main(String[] args) {
        int[] a = {3, 2, 5, 1};
        System.out.println(Arrays.toString(new InsertionSort().insertionSort(a)));
    }
}
