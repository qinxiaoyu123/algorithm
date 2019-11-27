import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n = input.nextInt();
        Integer arry []= new Integer[n];
        for(int i = 0 ; i < n ; i++){
            arry[i] = input.nextInt();
        }
        quickSort(arry, 0, n-1);
        for(int i = 0; i<n ; i++){
            if(i == n-1)
                System.out.print(arry[i]+" ");

            else
                System.out.print(arry[i]+" ");
        }


    }

    private static void quickSort(Integer[] arry, int l, int r) {
        if(r<=l) return;
        int x = arry[(l+r)/2];
        int i = l-1;
        int j = r+1;
        while(i<j){
            do i++; while(arry[i]<x);
            do j--; while(arry[j]>x);
            if(i<j){
                int tmp = arry[i];
                arry[i] = arry[j];
                arry[j] = tmp;
            }
        }
        quickSort(arry,l,j);
        quickSort(arry,j+1,r);
    }

}
