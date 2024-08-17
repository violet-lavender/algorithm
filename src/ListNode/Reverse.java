package ListNode;

// 链表反转问题
public class Reverse {
    // 206. 反转链表
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

    // 92. 反转链表 II
    // 巧妙的头插, 一次遍历完成
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode nP = new ListNode(0);
        nP.next = head;
        ListNode pre = nP;
        for (int i = 0; i < left - 1; i ++) {
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

    // 25. K 个一组翻转链表
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        ListNode left, right;
        left = right = head;
        for (int i = 0; i < k; i++) {
            // base case, 不足k个, 不需要反转
            if (right == null) {
                return head;
            }
            right = right.next;
        }
        // 反转前k个元组
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
