package basicAlgorithm;

import java.util.*;

public class BigSum {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        String a = input.next();
        String b = input.next();
        List<Integer> A = new ArrayList<Integer>(), B = new ArrayList<Integer>();
        for(int i = a.length()-1; i>=0; i--)
            A.add(a.charAt(i)-'0');
        for(int i = b.length()-1; i>=0; i--)
            B.add(b.charAt(i)-'0');
        List<Integer> C = sum(A,B);
        Collections.reverse(C);
        Iterator<Integer> iter = C.iterator();
        while(iter.hasNext())
            System.out.print(iter.next());
//        System.out.print("\n");

    }

    private static List<Integer> sum(List<Integer> a, List<Integer> b) {
        List<Integer> c = new ArrayList<Integer>();
        if(b.size()>a.size())
            return sum(b,a);
        int t = 0;
        for(int i = 0; i< a.size(); i++){
            t = t + a.get(i);
            if(i<b.size())
                t = t + b.get(i);
            c.add(t%10);
            t = t / 10;
        }
        if(t>0) c.add(t);
        return c;
    }
}
