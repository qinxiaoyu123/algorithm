package listNode;

import java.util.Arrays;

public class Solution {
    public int solution(int []X, int []Y){
        Arrays.sort(X);
        int maxValue = 0;
        for(int i = 1; i<X.length;i++){
            maxValue = Math.max(X[i]-X[i-1], maxValue );
        }
        return maxValue;
    }
}
