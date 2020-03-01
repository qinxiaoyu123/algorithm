package leetcode;

import java.util.ArrayList;
import java.util.List;

public class CanCompleteCircuit {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        if (n == 1) {
            if (gas[0] >= cost[0]) {
                return 0;
            }
            return -1;
        }
        int sum = 0;
        int[] diff = new int[n];
        int idx = -1;
        for (int i = 0; i < n; i++) {
            diff[i] = gas[i] - cost[i];
            sum += diff[i];
        }
        if (sum < 0) return -1;
        for (int i = 0; i < n; i++) {
            if (diff[i] > 0) {
                boolean flag = true;
                int sum1 = diff[i];
                for (int j = i + 1; j < n; j++) {
                    sum1 += diff[j];
                    if (sum1 < 0) {
                        flag = false;
                        break;
                    }

                }
                for (int j = 0; j < i; j++) {
                    sum1 += diff[j];
                    if (sum1 < 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag) return i;
            }
        }
        return -1;
    }
}
