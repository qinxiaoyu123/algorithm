package leetcode;

class Solution8 {
    public String getPermutation(int n, int k) {
        boolean[] f = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            f[i] = false;
        }
        StringBuilder s = new StringBuilder();
        for(int i = n - 1; i >= 1; i--){
            int mulRes = mul(i);
            //当前取得下标
            int t2 = (k-1) / mulRes;
            //下一轮的k
            k = (k-1) % mulRes;
            int count = 0;
            for(int j = 1;j<=n;j++){
                if(!f[j]){
                    count++;
                    if(count == t2+1){
                        f[j] = true;
                        s.append(String.valueOf(j));
                    }
                }
            }
        }
        return s.toString();
    }

    private int mul(int i) {
        int res = 1;
        if (i == 0 || i == 1) return res;
        while (i >= 1) {
            res = res * i;
            i--;
        }
        return res;
    }
}

public class Main8 {
}
