package leetcode;

class Solution5 {
    public int findLengthOfLCIS(int[] nums) {
        //边界判断！！！
        if(nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        int []f = new int[10010];
        int res = 1;
        f[0] = 1;
        for(int i = 1;i<nums.length;i++){
            if(nums[i] > nums[i-1]){
                f[i] = f[i-1] +1;
                res = Math.max(res, f[i]);
            }
            else f[i] = 1;
        }
        return res;
    }
}

public class Main5 {
}
