package dataStructure;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Heap {
    static int []h =new int[100010];
    static int []ph =new int[100010];
    static int []hp =new int[100010];
    static int size = 0;
    static int count = 0;
    public static void main(String []args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        while(n-->0){
            String []line1 = reader.readLine().split(" ");
            if(line1[0].equals("I")) insert(Integer.parseInt(line1[1]));
            else if (line1[0].equals("PM")) System.out.println(h[1]);
            else if (line1[0].equals("DM")) deleteSmall();
            // k = Integer.parseInt(line1[1]), map[k] 第k个插入数在heap中对应下标
            else if (line1[0].equals("D")) delete(Integer.parseInt(line1[1]));
            else modify(Integer.parseInt(line1[1]), Integer.parseInt(line1[2]));

        }

    }

    private static void modify(int k, int x) {
        int t = ph[k];
        h[t] = x;
        down(t);
        up(t);
    }

    private static void delete(int k) {
        int t = ph[k];
        h[t] = h[size];
        reviseMap(t,size);
        size -- ;
        down(t);
        up(t);
    }

    private static void deleteSmall() {
        h[1] = h[size];
        reviseMap(1,size);
        size -- ;
        down(1);
    }

    private static void insert(int x) {
        h[++size] = x;
        hp[size] = ++count;
        ph[count] = size;
        up(count);

    }

    private static void up(int t) {
        int i = t/2;
        if(h[t]<h[i]) {
            swap(t,i);
            up(i);
        }
    }

    private static void swap(int t, int i) {
        int tmp = h[t];
        h[t] = h[i];
        h[i] = tmp;
        reviseMap(t,i);

    }

    private static void reviseMap(int t, int i) {
        int k1 = hp[t], k2 = hp[i];
        ph[k1] = i;
        ph[k2] = t;
        hp[t] = k2;
        hp[i] = k1;
    }

    private static void down(int t) {
        int tmp = t;
        if(h[t*2]<h[tmp]) tmp = t*2;
        if(h[t*2+1]<h[tmp]) tmp = t*2+1;
        if(t != tmp){
            swap(t,tmp);
            down(tmp);
        }
    }

}
