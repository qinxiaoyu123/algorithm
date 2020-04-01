package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DetectCycle {
    //Leetcode142 检测链表环
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(true){
            if(fast == null || fast.next == null)
                return null;
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) break;
        }
        fast = head;
        while(true){
            if(fast == slow) return slow;
            fast = fast.next;
            slow = slow.next;

        }
    }
//    public ListNode detectCycle(ListNode head) {
//        if(head == null) return null;
//        Set<ListNode> sets = new HashSet<>();
//        ListNode tmp = head;
//        while(tmp != null){
//            if(sets.contains(tmp)){
//                return tmp;
//            }
//            sets.add(tmp);
//            tmp = tmp.next;
//        }
//        return null;
//    }
}
