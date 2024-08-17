package ListNode.TwoPointer;

import ListNode.ListNode;

// 两两交换链表中的节点
public class SwapPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nP = new ListNode(-1);
        nP.next = head;
        ListNode pre = nP;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null) {
            ListNode nxt = fast.next;
            pre.next = fast;
            slow.next = nxt;
            fast.next = slow;
            pre = slow;
            slow = nxt;
            fast = nxt == null ? null : nxt.next;
        }
        return nP.next;
    }
}
