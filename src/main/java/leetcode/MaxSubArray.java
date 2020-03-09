package leetcode;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int maxSum = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum < 0) sum = nums[i];
            else sum = sum + nums[i];
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }
}
