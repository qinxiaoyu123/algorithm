package leetcode;



import java.util.*;

class Node1{
    int x;
    int y;

    public Node1(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Node1{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
public class NumDistinctIslands {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0,-1};
    static Queue<Integer> queue = new LinkedList<>();
    static int N;
    static int M;
    static int count;
    static List<List<Node1>> lists = new ArrayList<>();
    public static int numDistinctIslands(int[][] grid) {
        if(grid.length == 0) return 0;
        int n = grid.length;
        int m = grid[0].length;
        count = 0;
        N = n;
        M = m;
        lists.clear();
        queue.clear();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == 1){
                    queue.offer(i);
                    queue.offer(j);
                    grid[i][j] = -1;
                    bfs(grid);

                }
            }
        }
        return count;
    }

    private static void bfs(int[][] grid) {
        List<Node1> list = new ArrayList<>();
        while(!queue.isEmpty()){
            int x = queue.poll();
            int y = queue.poll();
            list.add(new Node1(x, y));
            for(int i = 0;i<4;i++){
                int tmpX = x+dx[i];
                int tmpY = y+dy[i];
                if(tmpX >= 0 && tmpX < N && tmpY >= 0 && tmpY < M && grid[tmpX][tmpY] == 1){
                    queue.offer(tmpX);
                    queue.offer(tmpY);
                    grid[tmpX][tmpY] = -1;
                }
            }
        }
        int n = list.size();
        boolean find = false;
        for(List<Node1> listTmp : lists){
            if(listTmp.size() == n){
                int i ;
                int diffX = listTmp.get(0).getX() - list.get(0).getX();
                int diffY = listTmp.get(0).getY() - list.get(0).getY();
                for(i = 1; i< n; i++){
                    int yy = listTmp.get(i).getY() - list.get(i).getY();
                    int xx = listTmp.get(i).getX() - list.get(i).getX();
                    if(yy != diffY || xx != diffX){
                        break;
                    }
                }
                //相同
                if(i == n){
                    find = true;
                    break;
                }
            }
        }
        if(!find){
           lists.add(list);
           count++;
            System.out.println(list);
        }
    }

    public static void main(String[] args) {
        int [][] grid = {{1,0}};
        System.out.println(numDistinctIslands(grid));
    }
}
