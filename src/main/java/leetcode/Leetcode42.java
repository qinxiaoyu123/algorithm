package leetcode;

public class Leetcode42 {
    //接雨水问题
    public static void main(String[] args) {
        Leetcode42 l = new Leetcode42();
        System.out.println(l.trap(new int[]{5, 2, 1, 2, 1, 5}));

    }

    public int trap(int[] height) {
        //找每一个极小值点，从这个点开始i，j指针搜索周围极大值
        int result = 0;
        for (int i = 1; i < height.length - 1; i++) {
            boolean flag = false;
            int l = i - 1;
            int r = i + 1;
            int left = i;
            int sum = 0;
            while (l >= 0) {
                if (height[l] >= height[left]) {
                    left = l;
                }
                l--;
            }
            if (height[left] > height[i]) {
                flag = true;
            }
            int right = i;
            while (r < height.length) {
                if (height[r] >= height[right]) {
                    right = r;
                }
                r++;
            }
            if (height[right] <= height[i]) {
                flag = false;
            }

            if (flag) {
                if (height[right] > height[left]) {
                    right = i + 1;
                    while (height[right] <= height[left]) {
                        right++;
                    }
                } else if (height[right] < height[left]) {
                    left = i - 1;
                    while (height[right] >= height[left]) {
                        left--;
                    }
                }
//                System.out.println(left+" "+right);
                sum = Math.min(height[right], height[left]) * (right - left - 1);
                for (int k1 = left + 1; k1 < right; k1++) {
                    sum -= height[k1];
                }

                i = right;
            }
            result += sum;

        }
        return result;
    }
}
