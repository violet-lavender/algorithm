package ListNode.Sort;

import ListNode.ListNode;

// 对链表进行插入排序
public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nP = new ListNode(0);
        nP.next = head;
        ListNode lastSorted = head, cur = head.next;
        while (cur != null) {
            // 当前插入节点小于等于最后已排序节点, 直接插入
            if (lastSorted.val <= cur.val) {
                lastSorted = lastSorted.next;
            } else {
                ListNode pre = nP;
                while (pre.next.val <= cur.val) {
                    pre = pre.next;
                }
                lastSorted.next = cur.next;
                cur.next = pre.next;
                pre.next = cur;
            }
            cur = lastSorted.next;
        }
        return nP.next;
    }
}
