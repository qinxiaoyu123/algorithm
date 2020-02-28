package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        Set<ListNode> sets = new HashSet<>();
        ListNode tmp = head;
        while(tmp != null){
            if(sets.contains(tmp)){
                return tmp;
            }
            sets.add(tmp);
            tmp = tmp.next;
        }
        return null;
    }
}
