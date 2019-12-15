package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Queue {
    static int N = 100005;
    static int qq[] = new int[N];
    static int hh;
    static int tt;
    static void init(){
        //hh 不初始化
        tt = -1;
    }

    public static void main(String []args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int m =  Integer.valueOf(reader.readLine());
        init();
        while(m-->0){
            String []list = reader.readLine().split(" ");
            if(list[0].equals("push")){
                qq[++tt] = Integer.valueOf(list[1]);
            }
            else if(list[0].equals("pop"))
                hh++;
            else if(list[0].equals("empty"))
                if(tt<hh) System.out.println("YES");
                else System.out.println("NO");
            else System.out.println(qq[hh]);
        }

    }
}
