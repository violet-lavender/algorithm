package ListNode.Remove;

import ListNode.ListNode;

// 移除链表元素
public class RemoveElements {

    public ListNode removeElements(ListNode head, int val) {
        ListNode nP = new ListNode(0);
        nP.next = head;
        ListNode pre = nP;
        while(head != null ){
            if(head.val == val){
                pre.next = pre.next.next;
            }
            else{
                pre = head;
            }
            head = head.next;
        }
        return nP.next;
    }
}
