package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Trie {
    static int m = 100010;
    static int [][] son = new int [m][26];
    static int [] cont = new int [m];
    static int idx = 0;
    static void insert(String s){
        int p = 0;
        for(int i = 0;i <s.length();i++){
            int u = s.charAt(i) - 'a';
            if(son[p][u]==0) son[p][u] = ++idx;
            p = son[p][u];
        }
        cont[p] ++;
    }
    static int query(String s){
        int p =0;
        for(int i = 0;i <s.length();i++){
            int u = s.charAt(i) - 'a';
            if(son[p][u]!=0) p = son[p][u];
            else  return 0;
        }
        return cont[p];
    }
    public static void main (String []args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        while(n-->0){
            String line [] = reader.readLine().split(" ");
            if(line[0].equals("I")) insert(line[1]);
            else System.out.println(query(line[1]));
        }
        reader.close();
    }
}
