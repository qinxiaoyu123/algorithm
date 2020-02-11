package listNode;
//迭代方式实现
public class reverseListNode {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        ListNode cur = head;
        ListNode newHead = null;
        if(cur == null || cur.next == null) return cur;
        while(cur!= null){
            next = cur.next;
            cur.next = pre;
            if(next == null){
                newHead = cur;
            }
            pre = cur;
            cur = next;
        }
        return newHead;
    }
}
