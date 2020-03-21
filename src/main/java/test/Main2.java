package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main2 {
    static String [] a = new String[1000010];
    static int [] f = new int[1000010];
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        for(int i = 0; i<n;i++){
            a[i] = reader.readLine().trim();
        }
        Arrays.sort(a, 0, n, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int i = o1.charAt(0) - o2.charAt(0);
                if(i <0){
                    return -1;
                }
                else if(i >0){
                    return 1;
                }
                else{
                    return 0;
                }

            }
        });

        f[0] = a[0].length();
        for(int i = 1;i<n;i++){
            f[i] = a[i].length();
            for(int j = 0; j<i;j++){
                if(a[i].charAt(0) - a[j].charAt(a[j].length()-1)>=0){
                    f[i] = Math.max(a[i].length()+f[j], f[i]);
                }
            }
        }

        int count = 0;
        for(int i = 0;i<n;i++){
            count = Math.max(f[i],count);
        }
        System.out.println(count);
    }



}
