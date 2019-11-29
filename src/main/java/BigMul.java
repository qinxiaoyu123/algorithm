import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BigMul {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            String a = input.next();
            List<Integer> A = new ArrayList<Integer>(), C = null;
            int b = input.nextInt();
            for(int i = a.length()-1; i>= 0 ;i--)
                A.add(a.charAt(i) - '0');
            C = mul(A,b);
            for(int i = C.size()-1; i>=0; i--)
                System.out.print(C.get(i));
        }


    }

    private static List<Integer> mul(List<Integer> a, int b) {
        List<Integer> c = new ArrayList<Integer>();
        int k = 0;
        for(int i = 0; i < a.size() ; i++){
            c.add((a.get(i) * b + k) % 10);
            k = (a.get(i) * b + k) / 10;
        }
        while(k>0) {
            c.add(k % 10);
            k = k /10;
        }
        return c;
    }
}
