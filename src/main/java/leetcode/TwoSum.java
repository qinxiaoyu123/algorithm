package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i<nums.length;i++){
            for(int j = i+1; j<nums.length;j++){
                if(nums[i]+nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
}
