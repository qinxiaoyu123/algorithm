package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SingleLinkedList {
    static int e[] = new int[1000000];
    static int ne[] = new int[1000000];
    static int idx;
    static int head;
    public static void main(String [] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        init();
        int M = Integer.parseInt(str);

        while(M-->0){
            String[] str1 = reader.readLine().split(" ");
            if(str1[0].equals("H"))
                add_to_head(Integer.parseInt(str1[1]));
            else if(str1[0].equals("D"))
                delete(Integer.parseInt(str1[1])-1);
            else
                add(Integer.parseInt(str1[1])-1,Integer.parseInt(str1[2]));
        }
        for(int i = head;i!=-1;i=ne[i]){
            System.out.print(e[i]+" ");
        }

    }
    public static void init(){
        head = -1;
        idx = 0;
    }
    public static void add_to_head(int x){
        e[idx] = x;
        ne[idx] = head;
        head = idx;
        idx++;
    }
    public static void add(int k, int x){
        e[idx] = x;
        ne[idx] = ne[k];
        ne[k] = idx;
        idx++;
    }
    public static void delete(int k){
        if(k == -1) head = ne[head];
        else ne[k] = ne[ne[k]];
    }
}
