package leetcode;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer> list = new HashMap();
        int res = 0;
        for(int i = 0;i<nums.length;i++){
            if(!list.containsKey(nums[i])){
                if(list.containsKey(nums[i]-1) && list.containsKey(nums[i]+1) ){
                    int tmpLeft = nums[i]-1;
                    //tmpLeft指示最左边的指针
                    while(list.containsKey(tmpLeft-1)) tmpLeft--;
                    //tmpRight指示连续的最右边的指针
                    int tmpRight = nums[i] +1;
                    while(list.containsKey(tmpRight+1)) tmpRight++;
                    //更新长度
                    int tmpNew = list.get(tmpLeft)+1+list.get(tmpRight);
                    list.put(tmpLeft, tmpNew);
                    list.put(tmpRight, tmpNew);
                    list.put(nums[i], tmpNew);
                    res = Math.max(res, tmpNew);

                }
                else if(list.containsKey(nums[i]-1)){
                    int tmpLeft = nums[i]-1;
                    //tmpLeft指示最左边的指针
                    while(list.containsKey(tmpLeft-1)) tmpLeft--;
                    //更新长度
                    int tmpNew = list.get(tmpLeft)+1;
                    list.put(tmpLeft, tmpNew);
                    list.put(nums[i], tmpNew);
                    res = Math.max(res, tmpNew);
                }
                else if(list.containsKey(nums[i]+1)){
                    //tmpRight指示连续的最右边的指针
                    int tmpRight = nums[i] +1;
                    while(list.containsKey(tmpRight+1)) tmpRight++;
                    //更新长度
                    int tmpNew = 1+list.get(tmpRight);
                    list.put(tmpRight, tmpNew);
                    list.put(nums[i], tmpNew);
                    res = Math.max(res, tmpNew);
                }
                else{
                    list.put(nums[i], 1);
                    res = Math.max(res, 1);
                }

            }
        }
        return res;
    }
}
public class Main7{

}