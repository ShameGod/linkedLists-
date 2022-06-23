public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null){return false;}
        ListNode p1 = head;
        ListNode p2 = p1.next;
        int index = 0;
        while(p1!=p2){
            if(p2 == null){return false;}
            if(index%5==1){p1=p1.next;}
            p2=p2.next;
            index = index +1;
        }
        return true;
    }
}
