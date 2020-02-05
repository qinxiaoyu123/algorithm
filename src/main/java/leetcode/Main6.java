package leetcode;
//大顶堆
class Solution6 {
    static int n;
    static int []heap;
    static int size;
    public int findKthLargest(int[] nums, int k) {
        n = nums.length;
        heap = new int[n + 2];
        for (int i = 0; i < n; i++) {
            heap[i + 1] = nums[i];
        }
        size = n;
        for(int i = n/2;i>=1;i--){
            down(i);
        }
        for(int i = 1; i < k;i++){
//            System.out.println(heap[1]);
            heap[1] = heap[size];
            size--;
            down(1);
        }
        int res = heap[1];
//        System.out.println(res);
        return res ;
    }

    private void down(int i) {
        int t = i;//t指示最大的
        //不是判断小于等于n，是判断小于等于size
       if(2*i <= size && heap[2*i] > heap[t]) t = 2*i;
        if(2*i+1<= size && heap[2*i+1] > heap[t]) t = 2*i+1;
        if(t != i) {
            swap(i,t);
            down(t);
        }
    }

    private void swap(int i, int t) {
        int tmp = heap[i];
        heap[i] = heap[t];
        heap[t] = tmp;
    }
}

public class Main6 {
    public static void main(String []args){
        Solution6 s = new Solution6();
        int[] nums = {-1,2,0};
        s.findKthLargest(nums, 3);
    }

}
