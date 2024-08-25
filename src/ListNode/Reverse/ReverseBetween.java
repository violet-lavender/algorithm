package ListNode.Reverse;

import ListNode.ListNode;

// 反转链表 —— 区间反转
public class ReverseBetween {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode nP = new ListNode(0);
        nP.next = head;
        ListNode pre = nP;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode nxt;
        for (int i = 0; i < right - left; i++) {
            nxt = cur.next;
            cur.next = nxt.next;
            // 注意这里头插, 一定是 pre.next, 而不是 cur
            nxt.next = pre.next;
            pre.next = nxt;
        }
        return nP.next;
    }
}
