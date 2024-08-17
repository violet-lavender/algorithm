package ListNode.Partition;

import ListNode.ListNode;

// 分隔链表
// 把原链表分成两个子链表, 第一个子链表包含所有小于 x 的节点, 第二个子链表包含所有大于等于 x 的节点, 再把这两个子链表连接起来即可
public class Partition {

    public ListNode partition(ListNode head, int x) {
        ListNode nP1 = new ListNode(-1);
        ListNode nP2 = new ListNode(-1);
        ListNode p1 = nP1;
        ListNode p2 = nP2;
        ListNode p = head;
        while (p != null) {
            if (p.val < x) {
                p1.next = p;
                p1 = p1.next;
            } else {
                p2.next = p;
                p2 = p2.next;
            }
            // 不能直接让 p 指针前进, p = p.next; 这样结果链中会包含一个环, 要断开原链表中每个节点的 next 指针
            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }
        p1.next = nP2.next;
        return nP1.next;
    }
}
