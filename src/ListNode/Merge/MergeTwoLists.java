package ListNode.Merge;

import ListNode.ListNode;

// 合并两个有序链表
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 虚拟头结点 —— 当需要创造一条新链表时, 可以使用虚拟头结点简化边界处理情况的处理, 避免空指针
        ListNode nP = new ListNode(-1);
        ListNode p = nP;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                p.next = list1;
                p = p.next;
                list1 = list1.next;
            }else{
                p.next = list2;
                p = p.next;
                list2 = list2.next;
            }
        }
        if(list1 != null)
            p.next = list1;
        if(list2 != null)
            p.next = list2;
        return nP.next;
    }
}
