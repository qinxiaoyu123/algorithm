package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class DoubleLinkedList {
    static int N = 100005;
    static int []e = new int[N];
    static int []l = new int[N];
    static int []r = new int[N];
    static int idx;
    static void init(){
        r[0] = 1;
        l[1] = 0;
        idx = 2;
    }
    static void add(int k, int x){
        e[idx] = x;
        l[idx] = k;
        r[idx] = r[k];
        l[r[k]] = idx;
        r[k] = idx;
        idx++;
    }
    static void remove(int k){
        l[r[k]] = l[k];
        r[l[k]] = r[k];
    }

    public static void main(String []args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        init();
        int m = Integer.parseInt(str);
//        Scanner input = new Scanner(System.in);
//        int m = input.nextInt();
//        System.out.println(m);
        while(m-->0){
            String[] list = reader.readLine().split(" ");

//            int x  = Integer.valueOf(list[0]);
            if(list[0].equals("L")){
                add(0, Integer.valueOf(list[1]));
            }
            else if(list[0].equals("R")){
                add(l[1], Integer.valueOf(list[1]));
            }
            else if(list[0].equals("D")){
                remove(Integer.valueOf(list[1])+1);
            }
            else if(list[0].equals("IL")){
                int k = Integer.valueOf(list[1]);
                int x = Integer.valueOf(list[2]);
                add(l[k+1], x);
            }
            else{
                int k = Integer.valueOf(list[1]);
                int x = Integer.valueOf(list[2]);
                add(k+1, x);
            }
        }
        for(int i = r[0]; i != 1; i = r[i]){
            System.out.print(e[i]+" ");
        }
    }
}

















