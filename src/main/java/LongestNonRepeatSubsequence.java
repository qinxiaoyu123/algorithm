import java.util.Scanner;

import static java.lang.Math.max;

public class LongestNonRepeatSubsequence {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arry = new int[n];
        for (int i = 0; i < n; i++) {
            arry[i] = input.nextInt();
        }
        int [] s = new int[100002];
        int j = 0;
        int res = 0;
        for(int i = 0;i<n;i++){
            s[arry[i]]++;
            while(s[arry[i]]>1 && j <= i){
                    s[arry[j]] --;
                    j++;
            }
            res = max(res, i-j+1);
        }
        System.out.println(res);
    }
}
