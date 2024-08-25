package ListNode.Reverse;

import ListNode.ListNode;

// K 个一组翻转链表
public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        ListNode left, right;
        left = right = head;
        for (int i = 0; i < k; i++) {
            // base case, 不足 k 个, 不需要反转
            if (right == null) {
                return head;
            }
            right = right.next;
        }
        // 反转前 k 个元组
        ListNode newHead = reverse(left, right);
        // 递归反转后续链表并连接起来, 注意这里的连接逻辑
        left.next = reverseKGroup(right, k);
        return newHead;
    }

    // 注意左开右闭 [left, right)
    private ListNode reverse(ListNode left, ListNode right) {
        ListNode pre = null;
        ListNode cur = left;
        while (cur != right) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}
