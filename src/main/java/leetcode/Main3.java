package leetcode;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        int mid;
        while(l<r){
            mid = (l+r)>>1;
            if(nums[mid] == target) return mid;
            //左边有序
            if(nums[mid] >= nums[r]){
                if(nums[mid] > target && nums[l] <= target) r = mid - 1;
                else {
                    l = mid + 1;
                }
            }
            else{//右边有序
                if(nums[mid] < target && nums[r] >= target) l = mid + 1;
                else{
                    r = mid - 1;
                }

            }
        }
        //判断数组为[]的情况
        if(l>r) return -1;
        if(nums[l] == target) return l;
        else return -1;
    }
}
public class Main3 {
    public static void main(String []args){
        int [] a = new int[1];
        System.out.println(a.length);
    }

}
