package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMaximizedCapital {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        int result = W;
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
                W = W+prof;
            }
        }
        return result;
    }
    //大顶堆
    public int findMaximizedCapital1(int k, int W, int[] Profits, int[] Capital) {
        // to speed up: if all projects are available
        boolean speedUp = true;
        for (int c: Capital) if (W < c) speedUp = false;
        if (speedUp) {
            PriorityQueue<Integer> heap = new PriorityQueue<>();
            for (int p: Profits) {
                heap.add(p);
                if (heap.size() > k) heap.poll();
            }
            for (int h: heap) W += h;
            return W;
        }

        int idx;
        int n = Profits.length;
        for(int i = 0; i < Math.min(k, n); ++i) {
            idx = -1;
            // if there are available projects,
            // pick the most profitable one
            for(int j = 0; j < n; ++j) {
                if (W >= Capital[j]) {
                    if (idx == -1 ) idx = j;
                    else if (Profits[idx] < Profits[j]) idx = j;
                }
            }
            // not enough capital to start any project
            if(idx == -1) break;

            // add the profit from chosen project
            // and remove the project from further consideration
            W += Profits[idx];
            Capital[idx] = Integer.MAX_VALUE;
        }
        return  W;
    }


    public static void main(String[] args) {
        int k = 1;
        int w = 2;
        int [] a = new int[]{1,2,3};
        int [] b = new int[]{1,1,2};
        System.out.println(new FindMaximizedCapital().findMaximizedCapital(k,w,a,b));
    }
}
