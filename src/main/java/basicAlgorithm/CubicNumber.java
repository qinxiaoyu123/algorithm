package basicAlgorithm;

import java.util.Scanner;

public class CubicNumber {
    public static  void main(String []args){
        Scanner input = new Scanner(System.in);
        double n = input.nextDouble();
        double l = -10000;
        double r = 10000;
        while(r - l > 1e-8){
            double mid = (l+r)/2;
            if(mid *mid *mid>=n){
                r = mid;
//                System.out.println(r);
            }

            else {
                l = mid;
//                System.out.println(l);
            }
        }

        System.out.println(String.format("%.6f",l));
    }
}
