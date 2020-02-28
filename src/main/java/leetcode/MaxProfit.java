package leetcode;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        //状态标识，f[i]第i天卖出能获得的最大利益，有三种操作，买，卖，啥都不做
        //状态转移方程 f[i] =
        int n = prices.length;
        if (n == 1||n==0) return 0;
        int[] f = new int[n];
        f[0] = 0;
        int result = 0;
        for (int i = 1; i < n; i++) {
            int max = f[i-1];
            for (int j = 0; j < i; j++) {
                if (j - 1 < 0) {
                    max = Math.max(prices[i] - prices[j], max);
                } else {
                    max = Math.max(f[j - 1] + prices[i] - prices[j], max);
                }
            }
            f[i] = max;
            System.out.println(i+" "+f[i]);
            result = Math.max(result, f[i]);
        }

        return result;
    }
    public static void main(String []args){
        int []a = new int[]{3,2,6,5,0,3};
        System.out.println(new MaxProfit().maxProfit(a));

    }
}
