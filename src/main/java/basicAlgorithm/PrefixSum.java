package basicAlgorithm;

import java.util.Scanner;

public class PrefixSum {
    public static void main(String []args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        int arry[] = new int[n];
        for(int i = 0; i < n; i++)
            arry[i] = input.nextInt();
        int sum[] = new int[n+1];
        sum[0] = 0;
        for(int i = 0; i < n; i++)
            sum[i+1] = sum[i] + arry[i];
        while (k-->0){
            int l = input.nextInt(),r = input.nextInt();
            System.out.println(sum[r]-sum[l-1]);
        }
    }
}
