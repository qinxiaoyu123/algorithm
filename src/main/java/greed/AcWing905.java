package greed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;


public class AcWing905 {
    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
    static Node [] a = new Node [1000010];
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        for(int i = 0;i<n;i++){
            String[] s = reader.readLine().split("\\s+");
            a[i] = new Node(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
        }

        Arrays.sort(a, 0,n,new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.x < o2.x) return -1;
                else if (o1.x > o2.x) return 1;
                else {
                    if (o1.y < o2.y) return -1;
                    else if(o1.y > o2.y) return 1;
                    else return 0;
                }
            }
        });
//        for(int i = 0; i<n;i++)
//            System.out.println(a[i]);
        int count = 1;
        int right = a[0].y;
        for(int i = 1; i<n ;i++){
            if(a[i].x > right){
                right = a[i].y;
                count++;
            }
            if(a[i].y < right){
                right = a[i].y;
            }
        }
        System.out.println(count);
    }
}
