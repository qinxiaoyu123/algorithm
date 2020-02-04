package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.sort;

public class Main1 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        int idx  = 0;
        sort(nums);
        int length = nums.length;
        for(int i = 0; i<length;i++){
            if(nums[i]<=0 && (i== 0 ||nums[i]!=nums[i-1])){
                int left = i+1, right = length-1;
                int target = 0-nums[i];
                while(left < right ){
                    //去重，如果left指针移动但相等，则继续移动，注意左越界，left<right自动保证不右越界
                    if((left!=i+1)&&nums[left] == nums[left-1]){
                        left++;
                        continue;
                    }
                    //去重，也要注意右越界，left<right自动保证不会左越界
                    if((right != length-1) && nums[right] == nums[right+1]){
                        right--;
                        continue;
                    }
                    if (nums[left] + nums[right]==target){
                        results.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        left++;
                        right--;
                    }
                    else if(nums[left] + nums[right]>target){
                        right--;
                    }
                    else{
                        left++;
                    }
                }
            }
        }
        return results;
    }
}
