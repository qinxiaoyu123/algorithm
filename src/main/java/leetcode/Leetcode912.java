package leetcode;

public class Leetcode912 {
    //排序数组
    public static void main(String[] args) {
        Leetcode912 l = new Leetcode912();
        l.sortArray(new int[]{5, 1, 1, 2, 0, 0});
    }

    public int[] sortArray(int[] nums) {
        int n = nums.length;
        if (n == 0) return nums;
        quickSort(nums, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
        }
        return nums;
    }

    private void quickSort(int[] nums, int l, int r) {
        if (l >= r) return;
        int mid = (l + r) >> 1;
        int x = nums[mid];
        int k1 = l - 1;
        int k2 = r + 1;
        while (k1 < k2) {
            do {
                k1++;
            } while (nums[k1] < x);
            do {
                k2--;
            } while (nums[k2] > x);
            if (k1 < k2) {
                int tmp = nums[k1];
                nums[k1] = nums[k2];
                nums[k2] = tmp;
            }
        }
        quickSort(nums, l, k2);
        quickSort(nums, k2 + 1, r);
    }
}
