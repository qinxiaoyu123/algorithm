package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Solution10 {
    class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int[][] merge(int[][] intervals) {
        int m = intervals.length;

        if(m == 0 || m == 1){
            return intervals;
        }
        int [][]result = new int[m][2];
        Node []nodes = new Node[m];
        for(int i = 0;i<m;i++){
            nodes[i] = new Node(intervals[i][0], intervals[i][1]);
        }
        Arrays.sort(nodes,new Comparator<Node>(){

            @Override
            public int compare(Node o1, Node o2) {
                return o1.x-o2.x;
            }
        });
        int left = nodes[0].x;
        int right = nodes[0].y;
        int idx = 0;
        for(int i = 1;i<m;i++){

            if(nodes[i].x <= right){
                right = Math.max(right,nodes[i].y);
            }
            else{
                result[idx][0] = left;
                result[idx][1] = right;
                idx++;
                left= nodes[i].x;
                right =nodes[i].y;
            }
            if(i == m-1){
                result[idx][0] = left;
                result[idx][1] = right;
                idx++;
            }
        }
        int [][]result1 = new int[idx][2];
        for(int i = 0;i<idx;i++){
            result1[i] = result[i];
        }
        return result1;
    }
}

public class Main10 {

}
