package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SingleLinkedList {
    static int N = 100;
    static int []stk = new int[N];
    static int tt = -1;
    public static void main(String []args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        int M = Integer.parseInt(str);
        while(M-->0){
            String []list = reader.readLine().split(" ");
            if (list[0].equals("push")) {
                stk[++tt] = Integer.valueOf(list[1]);
            }
            else if (list[0].equals("pop")) {
                tt--;
            }
            else if (list[0].equals("empty")) {
                if(tt>=0)
                    System.out.println("No");
                else
                    System.out.println("Yes");
            }
            else if (list[0].equals("query")) {
                System.out.println(stk[tt]);
            }
        }

    }
}
