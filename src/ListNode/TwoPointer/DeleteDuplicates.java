package ListNode.TwoPointer;

import ListNode.ListNode;

// 删除排序链表中的重复元素
public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nP = new ListNode(-1);
        nP.next = head;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null) {
            if (slow.val != fast.val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        slow.next = null;
        return nP.next;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nP = new ListNode(-1);
        nP.next = head;
        ListNode slow = nP;
        ListNode fast = head;
        while (fast != null) {
            if (fast.next != null && fast.val ==fast.next.val) {
                // 直接跳过重复节点
                while (fast.next != null && fast.val == fast.next.val) {
                    fast = fast.next;
                }
                // 注意这里要多跳一次, 保证重复元素全部去掉
                fast = fast.next;
                if (fast == null) {
                    slow.next = null;
                }
                // 下一段元素也可能重复(被链到此时尾部的元素, if 和 else 都可能发生), 可以交给下一轮 while 循环判断
            } else {
                slow.next = fast;
                slow = slow.next;
                fast = fast.next;
            }
        }
        return nP.next;
    }
}
