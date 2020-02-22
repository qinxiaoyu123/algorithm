package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class ReconstructQueue {
    class Node{
        int x;
        int y;
        Node(int x ,int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public String toString(){
            return "["+x+","+y+"]";
        }
    }
    public int[][] reconstructQueue(int[][] people) {
        if(people.length == 0 || people.length == 1) return people;
        Node[] nodes = new Node[people.length];
        for(int i = 0; i< people.length;i++){
            nodes[i] = new Node(people[i][0],people[i][1]);
        }
        Arrays.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.y != o2.y){
                    return o1.y - o2.y;
                }
                else return o1.x - o2.x;
            }
        });
        for(int i = 1;i<people.length;i++){
            int target = nodes[i].y;
            int value = nodes[i].x;
            if(target == 0) continue;
            int count = 0;
            int j;
            for(j = 0;j<i;j++){
                if(nodes[j].x>=nodes[i].x){
                    count++;
                    if(count > target) break;
                }
            }
            j = j-1;
            if(j != i-1){
                Node tmp = nodes[i];
                int k = i-1;
                while(k>=j+1){
                    nodes[k+1] = nodes[k];
                    k--;
                }
                nodes[j+1] = tmp;
            }
//            for(int jj = 0;jj<people.length;jj++){
//                System.out.print(nodes[jj]+" ");
//            }
//            System.out.println();
        }
        for(int i = 0; i< people.length;i++){
            people[i][0] = nodes[i].x;
            people[i][1] = nodes[i].y;
        }
        return people;
    }
    public static void main(String []args){
        int [][] people = new int[][]{{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        ReconstructQueue r = new ReconstructQueue();
        for(int i = 0 ; i<people.length;i++){
            System.out.print(Arrays.toString(r.reconstructQueue(people)[i])+" ");
            System.out.println();
        }

    }
}
