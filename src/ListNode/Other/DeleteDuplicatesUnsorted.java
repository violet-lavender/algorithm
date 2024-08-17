package ListNode.Other;

import ListNode.ListNode;

import java.util.HashMap;

// 从未排序的链表中移除重复元素
public class DeleteDuplicatesUnsorted {

    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ListNode p = head;
        while (p != null) {
            map.put(p.val, map.getOrDefault(p.val, 0) + 1);
            p = p.next;
        }
        ListNode nP = new ListNode(-1);
        nP.next = head;
        // p 用来记录当前不重复链表的尾结点
        p = nP;
        while (p != null) {
            ListNode temp = p.next;
            while (temp != null && map.get(temp.val) > 1) {
                // 跳过重复节点, 直到找到不重复的节点
                temp = temp.next;
            }
            // 接入不重复的节点或尾部空指针, 注意尾部指针也在这里接入, 上面 temp 会多跳一次, 最后到 null
            p.next = temp;
            p = p.next;
        }
        return nP.next;
    }
}
