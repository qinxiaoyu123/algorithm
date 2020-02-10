package leetcode;

class Solution12 {
    //迭代
//    public ListNode reverseList(ListNode head) {
//        ListNode newHead = new ListNode(0);
//        newHead.next = null;
//        //迭代
//        ListNode iter = head;
//        while(iter != null){
//            //每次在newHead后面插入
//            ListNode t = new ListNode(iter.val);
//            t.next = newHead.next;
//            newHead.next = t;
//            iter = iter.next;
//        }
//        return newHead.next;
//    }
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        if(head == null) {
            newHead = new ListNode(0);
            newHead.next = null;
            return newHead;
        }
        //在后面加
        else{
            newHead = reverseList(head.next);
            ListNode tmp = new ListNode(head.val);
            tmp.next = newHead.next;
            newHead.next = tmp;
            return tmp;
        }
    }
}

public class Main12 {
}
