import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BigDiv {
    public static void main(String []args){
        Scanner input = new Scanner(System.in);
        List<Integer> A = new ArrayList<Integer>(), C = null;
        String a = input.next();
        int b = input.nextInt();
        for(int i = a.length() - 1; i>=0;i--){
            A.add(a.charAt(i) - '0');
        }
        C= div(A,b);
        for(int i = 0;i < C.size();i++)
            System.out.print(C.get(i));
    }

    private static List<Integer> div(List<Integer> a, int b) {
        List<Integer> c = new ArrayList<Integer>();
        int tmp = 0;
        for(int i = a.size() - 1; i>=0;i--){
            tmp = tmp *10 + a.get(i);
            c.add(tmp/b);
            tmp = tmp%b;

        }
        while (c.size()>1 && c.get(c.size()-1)==0) c.remove(c.size()-1);
        return c;
    }
}