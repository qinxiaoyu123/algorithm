package leetcode;

import java.util.Arrays;
//lession 4 _2

class Solution99 {
    public int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] + 1 != A[i + 1]) {
                return 0;
            }
        }
        return 1;
    }
}
public class Other1 {
    public static void main(String []args){

    }
}
