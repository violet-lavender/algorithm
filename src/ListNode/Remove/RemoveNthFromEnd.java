package ListNode.Remove;

import ListNode.ListNode;

// 删除链表的倒数第 N 个节点
public class RemoveNthFromEnd {

    // 单链表的倒数第 k 个节点
    public ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        // p1 先走 k 步
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        // 两个指针同时走, 直到 p1 到达链表尾部的空指针(即 n - k 步)
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        // 此时 p2 指向第 n - k + 1 个节点, 即倒数第 k 个节点
        return p2;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode nP = new ListNode(-1);
        nP.next = head;
        // 删除倒数第 n 个节点, 找到倒数第 n + 1 个节点
        ListNode node = findFromEnd(nP, n + 1);
        node.next = node.next.next;
        return nP.next;
    }
}
