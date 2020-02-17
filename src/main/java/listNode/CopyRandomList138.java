package listNode;

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class CopyRandomList138 {
    public Node copyRandomList(Node head) {
        Map<Node, Node> nodes = new HashMap<>();
        Node iter = head.next;
        Node headNew = new Node(head.val);
        nodes.put(head, headNew);
        Node tmp1 = headNew;
        while(iter != null){
            Node tmp = new Node(iter.val);
            nodes.put(iter, tmp);
            tmp1.next = tmp;
            tmp1 = tmp;
            iter = iter.next;
        }
        tmp1.next = null;
        Node iter1 = head;
        Node iter2 = headNew;
        while(iter1 != null){
            if(iter1.random != null){
                iter2.random = nodes.get(iter1.random);
            }
            else iter2.random = null;
            iter1 = iter1.next;
            iter2 = iter2.next;
        }
        return headNew;
    }
}
