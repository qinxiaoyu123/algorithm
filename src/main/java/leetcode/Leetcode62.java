package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode62 {
    int lastRemaining(int n, int m) {
        int pos = 0;
        for(int i = 2; i <= n; i++){
            pos = (pos + m) % i;  // 每次循环右移
        }
        return pos;
    }
    //时间复杂度高
//    public int lastRemaining(int n, int m) {
//        Queue<Integer> queue = new LinkedList<>();
//        Queue<Integer> queue1 = new LinkedList<>();
//        Queue<Integer> tmp = queue;
//        Queue<Integer> tmp1 = queue1;
//        for(int i = 0;i<n;i++) queue.offer(i);
//        int i = 1;
//        while(queue.size()+queue1.size()!=1){
//            if(queue.size()==0) {
//                tmp = queue1;
//                tmp1 = queue;
//            }
//            else {
//                tmp = queue;
//                tmp1 = queue1;
//            }
//
//            if(i==m){
//                System.out.println(tmp.poll());
//                i=1;
//            }
//            else{
//                tmp1.offer(tmp.poll());
//                i++;
//            }
//        }
//        if(queue.size()!=0) return queue.poll();
//        else return queue1.poll();
//    }
}
