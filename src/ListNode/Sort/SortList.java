package ListNode.Sort;

import ListNode.ListNode;

import java.util.List;

// 链表排序, 传统归并, 时间复杂度O(nlogn), 空间复杂度O(logn)
public class SortList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }

    // 注意这里不但要返回链表的中点(两个时返回靠后的), 还要断开链表
    private ListNode getMid(ListNode head) {
        ListNode preMid = null;
        while (head != null && head.next != null) {
            preMid = preMid == null ? head : preMid.next;
            head = head.next.next;
        }
        ListNode mid = preMid.next;
        preMid.next = null;
        return mid;
    }

    // 合并两个链表
    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                p.next = list1;
                list1 = list1.next;
            } else {
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }
        p.next = list1 == null ? list2 : list1;
        return dummy.next;
    }
}
