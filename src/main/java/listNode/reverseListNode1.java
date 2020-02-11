package listNode;
//使用递归方式实现
public class reverseListNode1 {
    public ListNode reverseList(ListNode head) {
        if(head.next == null || head == null){
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
