package ListNode;

// 链表合并问题
public class Merge {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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
