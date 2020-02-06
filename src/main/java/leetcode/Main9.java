package leetcode;
//并查集
class Solution9 {
   static int[] p = new int[210];
    public int findCircleNum(int[][] M) {
        for(int i = 0;i<M.length;i++){
            p[i] = i;
        }
        for(int i = 0;i<M.length;i++){
            for(int j = 0;j<i;j++){//对称图，测一半就行
                if(M[i][j] == 1){
                    int px = find(i);
                    if(px != j){
                        p[px] = j;
                    }
                }
            }
        }
        int count = 0;
        for(int i = 0;i<M.length;i++){
            if(p[i] == i) count++;
        }
        return count;
    }

    private int find(int i) {
        if(p[i] != i) p[i] = find(p[i]);
        return p[i];
    }
}

public class Main9 {
}
