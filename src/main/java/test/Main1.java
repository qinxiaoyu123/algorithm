package test;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split("\\s+");
        int n = Integer.parseInt(s[0]);
        int l = Integer.parseInt(s[1]);
        int i = l;
        while (i <= 100) {
            int i1 = 2 * n + i - i * i;
            if (i1 % (2 * i) == 0) {
                int left = i1 / (2 * i);
                for (int j = 0; j < i-1; j++) {
                    System.out.print(left + " ");
                    left++;
                }
                System.out.print(left);
                return;
            }
            i++;
        }
        System.out.println("No");

    }
}