package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums.length == 1 || nums.length == 0) return;
        boolean flag = false;
        for(int i = nums.length-1;i>=1;i--){
            if(nums[i] > nums[i-1]){
                //比他大并且距离他最近的那个数字
                int idx = i;
                int res = nums[i] - nums[i-1];
                for(int j = i+1;j<nums.length;j++){
                    int diff = nums[j] - nums[i-1];
                    if(diff > 0 && diff<res){
                        idx = j;
                        res = diff;
                    }
                }
                //交换
                int tmp = nums[idx];
                nums[idx] = nums[i-1];
                nums[i-1] = tmp;
                Arrays.sort(nums,i,nums.length);
                flag = true;
                break;
            }
        }
        if(!flag) Arrays.sort(nums);
    }
    public static void main(String []args){
        int [] a = new int[]{1,3,2};
        NextPermutation n = new NextPermutation();
        n.nextPermutation(a);
        System.out.println(Arrays.toString(a));
    }
}
