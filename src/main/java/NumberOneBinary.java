import java.util.Scanner;

public class NumberOneBinary {
    public static void main(String []args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        while(n-->0){
            int x = input.nextInt();
            int count = 0;
            while(x>0) {
                x -= lowbit(x);
                count++;
            }
            System.out.print(count+" ");
        }

    }

    private static int lowbit(int n) {
        return n & -n;
    }
}
