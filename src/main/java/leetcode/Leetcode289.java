package leetcode;

public class Leetcode289 {
    //生命游戏
    //复制一份数组

//    遍历 board 中的细胞。
//    根据数组的细胞状态计算新一轮的细胞状态，这里会用到能同时代表过去状态和现在状态的复合状态。
//    具体的计算规则如下所示：
//    规则 1：如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡。这时候，将细胞值改为 -1，代表这个细胞过去是活的现在死了；
//    规则 2：如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活。这时候不改变细胞的值，仍为 1；
//    规则 3：如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡。这时候，将细胞的值改为 -1，代表这个细胞过去是活的现在死了。可以看到，因为规则 1 和规则 3 下细胞的起始终止状态是一致的，因此它们的复合状态也一致；
//    规则 4：如果死细胞周围正好有三个活细胞，则该位置死细胞复活。这时候，将细胞的值改为 2，代表这个细胞过去是死的现在活了。
//
//    根据新的规则更新数组；
//    现在复合状态隐含了过去细胞的状态，所以我们可以在不复制数组的情况下完成原地更新；
//    对于最终的输出，需要将 board 转成 0，1 的形式。因此这时候需要再遍历一次数组，将复合状态为 2 的细胞的值改为 1，复合状态为 -1 的细胞的值改为 0。


    static int []dx = {-1,0,1,0,1,-1,-1,1};
    static int []dy = {0,-1,0,1,1,1,-1,-1};
    public void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        int [][] a = new int[n][m];

        for(int i = 0; i<n;i++){
            for(int j = 0;j<m;j++){
                a[i][j] = board[i][j];
            }
        }
        for(int i = 0; i<n;i++){
            for(int j = 0;j<m;j++){
                //统计周围的活细胞个数
                int countAlive = 0;
                for(int k = 0;k<8;k++){
                    int x = i+dx[k];
                    int y = j+dy[k];
                    if(x>=0 && x<n && y>=0 && y<m){
                        if(a[x][y] == 1){
                            System.out.println(x+" "+y);
                            countAlive++;
                        }
                    }
                }
                System.out.println();
                System.out.print(countAlive+" ");
                if(a[i][j] == 1){
                    if(countAlive <2){
                        //如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
                        board[i][j] = 0;
                    }
                    else if(countAlive > 3){
                        //如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
                        board[i][j] = 0;
                    }
                }
                else if(a[i][j] == 0 ){
                    if(countAlive == 3){
                        board[i][j] = 1;
                    }
                }
            }
            System.out.println();
        }
    }
}
