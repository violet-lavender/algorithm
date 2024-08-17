package ListNode;

// 双指针问题
public class TwoPoint {
    // 单链表的倒数第k个节点
    public ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        // p1先走k步
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        // 两个指针同时走, 直到p1到达链表尾部的空指针(即 n-k 步)
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        // 此时 p2 指向第 n-k+1 个节点, 即倒数第 k 个节点
        return p2;
    }

    // 19. 删除链表的倒数第N个节点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode nP = new ListNode(-1);
        nP.next = head;
        // 删除倒数第 n 个节点, 找到倒数第 n+1 个节点
        ListNode node = findFromEnd(nP, n+1);
        node.next = node.next.next;
        return nP.next;
    }

    // 876. 链表的中间结点
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast!= null && fast.next!= null) {
            // 慢指针走一步, 快指针走两步
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 160. 相交链表
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            if (pA == null) {
                pA = headB;
            } else {
                pA = pA.next;
            }
            if (pB == null) {
                pB = headA;
            } else {
                pB = pB.next;
            }
        }
        return pA;
    }

    // 83. 删除排序链表中的重复元素
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

    // 82. 删除排序链表中的重复元素 II
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

    // 24. 两两交换链表中的节点
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nP = new ListNode(-1);
        nP.next = head;
        ListNode pre = nP;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null) {
            ListNode nxt = fast.next;
            pre.next = fast;
            slow.next = nxt;
            fast.next = slow;
            pre = slow;
            slow = nxt;
            fast = nxt == null ? null : nxt.next;
        }
        return nP.next;
    }
}
