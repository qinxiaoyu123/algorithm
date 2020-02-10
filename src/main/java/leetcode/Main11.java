package leetcode;
//有序链表



class Solution11 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        head.next = null;
        ListNode tmp1 = l1;
        ListNode tmp2 = l2;
        ListNode tmp = head;
        while(tmp1 != null || tmp2 != null){
            if(tmp1 == null && tmp2 == null) tmp.next = null;
            else{
                ListNode result = null;
                if((tmp1 != null && tmp2 != null && tmp1.val<=tmp2.val) ||(tmp2 ==null && tmp1 != null)) {
                    result = new ListNode(tmp1.val);
                    tmp1 = tmp1.next;
                }
                else{
                    result =  new ListNode(tmp2.val);
                    tmp2 = tmp2.next;
                }
                result.next = tmp.next;
                tmp.next = result;
                tmp = result;
            }
        }
        return head.next;
    }
}
public class Main11 {
}
