package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Good{
    private int v;
    private int w;

    public int getV() {
        return v;
    }

    public int getW() {
        return w;
    }
    Good(int v, int w){
        this.v = v;
        this.w = w;
    }
}
public class CompleteBackpackS12 {
    static int N = 1000;
    static int idx;
    static Good [] goods = new Good[11000];
    static int[] f = new int[11000];
    public static void main(String []args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String []line = reader.readLine().split("\\s+");
        int n = Integer.parseInt(line[0]), v = Integer.parseInt(line[1]);
        for(int i = 1; i<=n;i++){
            String []list = reader.readLine().split("\\s+");
            int vi = Integer.parseInt(list[0]);
            int wi = Integer.parseInt(list[1]);
            int si = Integer.parseInt(list[2]);
            for(int k = 1; k<= si; k= k*2){
                idx++;
                si -= k;
                goods[idx] = new Good(vi*k,wi*k);
            }
            if(si>0){
                idx++;
                goods[idx] = new Good(vi*si,wi*si);
                break;
            }
        }
        for(int i = 1; i<=idx;i++){
            for(int j = v;j>=goods[i].getV();j--){
                f[j] = Math.max(f[j], f[j - goods[i].getV()] + goods[i].getW());
            }
        }
        System.out.println(f[v]);
    }


}
