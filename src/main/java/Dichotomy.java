import java.util.Scanner;

public class Dichotomy {

    public static void main(String [] args){
        Scanner input  = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        Integer arry[] = new Integer[n];
        for(int i = 0; i<n ;i++){
            arry[i] = input.nextInt();
        }
        while( k-- > 0){
           int x = input.nextInt();
           dichotomy(arry,x,n);
        }
    }

    private static void dichotomy(Integer[] arry, int x, int n) {
        int l = 0, r = n-1;
        while(l<r){
            int mid = (l+r)>>1;
            if(arry[mid]>=x) r = mid;
            else l = mid + 1;
        }
        if(arry[l] != x) System.out.println("-1 -1");
        else{
            System.out.print(l+" ");
            l = 0; r = n -1;
            while(l<r){
                int mid = (l+r+1)>>1;
                if(arry[mid]<=x) l = mid;
                else r = mid - 1;
            }
            System.out.println(l);
        }

    }

}
