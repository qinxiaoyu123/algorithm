package leetcode;

public class Search {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int mid;
        while (l <= r) {
            mid = (l + r) >> 1;
            if (nums[mid] == target) return mid;
            //右边有序
            if (nums[mid] < nums[r]) {
                if (target <= nums[mid] || target > nums[r]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            //左边有序
            else {
                if (target >= nums[mid] || target < nums[l]) {
                    l = mid + 1;

                } else {
                    r = mid - 1;
                }

            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1, 3};
        Search s = new Search();
        System.out.println(s.search(a, 2));
    }

}
