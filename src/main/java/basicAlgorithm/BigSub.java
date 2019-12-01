package basicAlgorithm;

import java.util.*;

public class BigSub {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            String a = input.next(), b = input.next();
            List<Integer> A = new ArrayList<Integer>(), B = new ArrayList<Integer>();
            for(int i = a.length() - 1 ; i>=0 ;i--)
                A.add(a.charAt(i)-'0');
            for(int i = b.length() - 1 ; i>=0 ;i--)
                B.add(b.charAt(i)-'0');

            List<Integer> C = null;

            if (!compare(A,B)) {
                System.out.print("-");
                C = sub(B,A);
            }else{
                C = sub(A,B);
            }

            for(int i = C.size()-1; i>=0;i--){
                System.out.print(C.get(i));
            }
        }

    }

    private static List<Integer> sub(List<Integer> a, List<Integer> b) {
        List <Integer> c = new ArrayList<Integer>();
        int tmp = 0;
        for(int i = 0; i< a.size(); i++){
            tmp = a.get(i) - tmp;
            if(i<b.size()) tmp  = tmp -b.get(i);
            c.add((tmp+10)%10);
            if(tmp < 0) tmp = 1;
            else tmp = 0;
        }
        while (c.size()>1 && c.get(c.size()-1)==0) c.remove(c.size()-1);
        return c;
    }

    private static boolean compare(List<Integer> a, List<Integer> b) {
        if(a.size() != b.size()) return a.size()>b.size();
        for(int i = a.size()-1 ; i>=0 ; i--)
            if(a.get(i) != b.get(i)) return a.get(i)>b.get(i);
        return true;
    }

}
