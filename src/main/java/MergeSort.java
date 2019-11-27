import java.util.Scanner;

public class MergeSort {
    public static void  main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Integer arry[] = new Integer[n];
        for(int i = 0; i < n; i++){
            arry[i] = input.nextInt();
        }
        mergeSort(arry,0,n-1);
        for(int i = 0; i < n; i++){
            if( i == n-1) System.out.print(arry[i]);
            else System.out.print(arry[i]+" ");
        }
    }

    private static void mergeSort(Integer[] arry, int l, int r) {
        if (l>=r) return;
        int mid = (l+r)/2;
        mergeSort(arry,l,mid);
        mergeSort(arry,mid+1,r);
        Integer tmp []= new Integer[r-l+1];
        int k = 0, i = l, j = mid+1;
        while(i<=mid && j<=r)
            if(arry[i]<=arry[j]) tmp[k++] = arry[i++];
            else tmp[k++] = arry[j++];
        while(i<=mid) tmp[k++] = arry[i++];
        while (j<=r) tmp[k++] = arry[j++];
        for( i = l, j = 0; i<=r;i++,j++) arry[i] = tmp[j];

    }
}
