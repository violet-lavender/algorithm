package ListNode.Reverse;

import ListNode.ListNode;

// 反转链表 —— 可以通过栈、递归、迭代实现, 最优解是迭代
public class ReverseList {

    // 迭代, 时间复杂度O(n), 空间复杂度O(1)
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    // 递归, 时间复杂度O(n), 空间复杂度O(n)
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList1(head.next);  // 递归翻转子链表
        head.next.next = head;    // 将子链表的尾节点指向当前节点
        head.next = null;        // 当前节点指向空, 成为新的尾节点
        return newHead;
    }
}
