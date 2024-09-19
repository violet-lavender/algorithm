package ListNode.Reverse;

import ListNode.ListNode;

// 反转链表 —— 区间反转
public class ReverseBetween {

    public ListNode reverseBetween0(ListNode head, int left, int right) {
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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reverseN(head, right);
        }
        if (left == right) {
            return head;
        }
        ListNode pre = head;
        for (int i = 1; i < left - 1; i++) {
            pre = pre.next;
        }
        pre.next = reverseN(pre.next, right - left + 1);
        return head;
    }

    private ListNode reverseN(ListNode head, int n) {
        if (head == null || head.next == null || n == 1) {
            return head;
        }
        ListNode pre = null, cur = head, nxt;
        for (int i = 0; i < n; i++) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        head.next = cur;
        return pre;
    }
}
