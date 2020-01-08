package dataStructure;

import java.io.*;

public class HashString {
    static int prime = 131 ;
    static long mod = Long.MAX_VALUE;
    static long [] pre ;
    static long [] power ;
    public static void main (String [] args) throws IOException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = in.readLine();
        String [] values = line.split("\\s+");
        int n = Integer.parseInt(values[0]);
        int m = Integer.parseInt(values[1]);
        String t = in.readLine();
        hash(t);
        while (m-- > 0) {
            values = in.readLine().split("\\s+");
            int l1 = Integer.parseInt(values[0]);
            int r1 = Integer.parseInt(values[1]);
            int l2 = Integer.parseInt(values[2]);
            int r2 = Integer.parseInt(values[3]);
            long p = get(l1, r1);
            long q = get(l2, r2);
            log.write(p == q ? "Yes" : "No") ;
            log.write("\n");
        }
        log.flush();
        log.close();

    }

    public static void hash (String s){
        int n = s.length();
        pre = new long [n + 1] ;
        power = new long [n + 1] ;
        power[0] = 1 ;
        for (int i = 1 ; i <= n ; ++i) {
            pre[i] = (pre[i - 1] * prime + (s.charAt(i - 1) - 'a' + 1)) % mod ;
            power[i] = power[i - 1] * 131 ;
        }
    }

    public static long get (int l, int r){
        return pre[r] - pre[l - 1] * power[r - l + 1] ;
    }

}
