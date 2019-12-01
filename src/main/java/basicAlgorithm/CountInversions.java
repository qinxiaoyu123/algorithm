package basicAlgorithm;

import java.util.Scanner;

public class CountInversions {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Integer arry[] = new Integer[n];
        for(int i = 0; i<n; i++){
            arry[i] = input.nextInt();
        }
        long count = countInversions(arry,0,n-1);
        System.out.println(count);
    }

    private static long countInversions(Integer[] arry, int l, int r) {
        if (l>=r) return 0;
        int mid = (l+r)>>1;
        long count = 0;
        count += countInversions(arry,l,mid);
        count += countInversions(arry,mid+1,r);
        Integer tmp [] = new Integer[r-l+1];
        int k = 0, i = l, j = mid+1;
        while(i <= mid && j <= r)
            if(arry[i]<=arry[j]) tmp[k++] = arry[i++];
            else {
                count += (mid - i + 1);
                tmp[k++] = arry[j++];

            }
        while(i<=mid) tmp[k++] = arry[i++];
        while (j<=r) tmp[k++] = arry[j++];
        for( i = l, j = 0; i<=r;i++,j++) arry[i] = tmp[j];
        return count;
    }


}
