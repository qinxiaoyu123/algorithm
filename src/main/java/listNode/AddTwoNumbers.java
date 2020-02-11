package listNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode pre = head;
        ListNode cur = null;
        int last = 0;
        while(l1 != null || l2 != null){
            int l1Value = l1 != null? l1.val:0;
            int l2Value = l2 != null? l2.val:0;
            int sumTmp = l1Value+l2Value+last;
            if(sumTmp>=10){
                last = 1;
                sumTmp = sumTmp- 10;
            }
            else{
                last = 0;
            }
            cur = new ListNode(sumTmp);
            pre.next = cur;
            pre = cur;
            //判空
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        if(last == 1){
            //判最后
            cur = new ListNode(1);
            pre.next = cur;
        }
        return head.next;
    }
}
