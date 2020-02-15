package listNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//基于快速排序做
public class SortList {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode iter = head;
        while(iter.next != null){
            iter = iter.next;
        }
        quickSortList(head, iter);
        return head;
    }

    private void quickSortList(ListNode head, ListNode end) {
        if(head == null || end == null || head == end|| (head.next == end && head.val<= end.val)) {
//             System.out.println("aaa "+head.val+" "+end.val);
            return;
        }
        System.out.println(head.val+" "+end.val);
        ListNode b = head;
        ListNode pre = head;
        int x = head.val;
        ListNode p = head.next;
        while(p != end.next){
            if(p.val>=x){
                p = p.next;
            }
            else{
                pre = b;
                b = b.next;
                 System.out.println("bp "+b.val+" "+p.val);
                if(b != p){
                    int tmp = p.val;
                    p.val = b.val;
                    b.val = tmp;
                }
                p = p.next;
            }
        }
        int tmp1 = b.val;
        b.val = head.val;
        head.val = tmp1;
        quickSortList(head, pre);
        quickSortList(b,p);
    }
    public static void main(String []args){
        //[-1,5,3,4,0]
        SortList s = new SortList();
        ListNode head = new ListNode(-1);
        ListNode n1 = new ListNode(5);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(0);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;
        s.sortList(head);
        ListNode iter = head;
        while(iter != null){
            System.out.print(iter.val+" ");
            iter = iter.next;
        }
    }
}
