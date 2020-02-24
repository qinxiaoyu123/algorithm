package leetcode;


import java.util.ArrayList;
import java.util.List;

public class NextLargerNodes {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> results = new ArrayList<>();
        if(head == null ) return new int[]{};
        if(head.next == null) return new int[]{0};
        ListNode tmp = head;
        while(tmp != null){
            ListNode iter = tmp.next;
            while(iter!= null && iter.val<=tmp.val){
                iter = iter.next;
            }
            if(iter == null){
                results.add(0);
            }
            else results.add(iter.val);
            tmp = tmp.next;
        }
        int size = results.size();
        int [] a = new int[size];
        for(int i = 0;i<size;i++){
            a[i] = results.get(i);
        }
        return a;
    }
}
