package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class FindMaximizedCapital {
    class Job {
        int profits;
        int captial;

        public Job(int profits, int captial) {
            this.profits = profits;
            this.captial = captial;
        }
    }

    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        int result = 0;
        int n = Profits.length;
        while (k-- > 0) {
            int index = -1;
            int prof = 0;
            int cap = 0x3f3f3f3f;
            for (int i = 0; i < n; i++) {
                if(Capital[i]<=W && (Profits[i]>prof || (Profits[i] == prof && Capital[i] <cap))){
                    index = i;
                    prof = Profits[i];
                    cap = Capital[i];
                }
            }
            if(index != -1){
                Profits[index] = -1;
                result = result+prof;
                W = W-cap+prof;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int k = 1;
        int w = 2;
        int [] a = new int[]{1,2,3};
        int [] b = new int[]{1,1,2};
        System.out.println(new FindMaximizedCapital().findMaximizedCapital(k,w,a,b));
    }
}
