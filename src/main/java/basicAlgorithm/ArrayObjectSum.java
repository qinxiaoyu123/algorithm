package basicAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ArrayObjectSum {
    public static void main(String [] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = reader.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int x = Integer.parseInt(str[2]);
        int [] A = new int[n], B = new int[m];
        String[] str1 = reader.readLine().split(" ");
        for(int i = 0; i<n; i++)
            A[i] = Integer.parseInt(str1[i]);
        String[] str2 = reader.readLine().split(" ");
        for(int i = 0; i<m; i++)
            B[i] = Integer.parseInt(str2[i]);
        for (int i = 0, j = m - 1; i < n; i++) {
            while (B[j] + A[i] > x && j > 0) j--;
            if (j >= 0 && B[j] + A[i] == x) {
                System.out.println(i + " " + j);
            }
        }
    }
}