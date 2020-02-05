package leetcode;
//leetcode 34题

class Solution4 {
    public int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        int mid;
        while(l<r){
            mid = (l+r)>>1;
            //左区间边界
            if(nums[mid]>=target) r = mid;
            else l = mid + 1;
        }
        if( l<= r && nums[l] == target){
            return  new int []{l, findRight(nums, target)};
        }
        return new int []{-1,-1};
    }

    private int findRight(int []nums, int target) {
        int l = 0, r = nums.length-1;
        int mid;
        while(l<r){
            //忘记加1
            mid = (l+r+1)>>1;
            //右区间边界
            if(nums[mid]<=target) l = mid;
            else r = mid - 1;
        }
        if(l<=r && nums[l] == target) return l;
        else return -1;
    }
}

public class Main4 {
}
