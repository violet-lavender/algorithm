package ListNode.Reverse;

import ListNode.ListNode;

// 旋转链表 —— 将链表每个节点向右移动 k 个位置, 即将后k个元素移到链表头部, 注意k = k % n 是常规处理
public class RotateRight {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return null;
        int n = 1, i = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            n++;
        }
        k = k % n;
        if (k == 0)
            return head;
        ListNode cur = head;
        while (i < n - k) {
            cur = cur.next;
            i++;
        }
        ListNode kPre = cur;
        cur = cur.next;
        ListNode kNode = cur;
        tail.next = head;
        kPre.next = null;
        return kNode;
    }

    //另一种思路:先将整个链表反转,然后将前n-k个节点和后k个节点分别反转
}
