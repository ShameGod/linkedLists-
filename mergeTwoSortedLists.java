/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //GIVEN
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode sortedHead = new ListNode(0);
        // INIT CONDITIONS
        if(list1==null){return list2;}
        if(list2==null){return list1;}
        // INIT VARIABLES
        if(p1.val <p2.val){
                sortedHead.val = p1.val;
                p1 = p1.next;
            }else{
                sortedHead.val = p2.val;
                p2 = p2.next;
            }
        ListNode iteratorNode = sortedHead;
        //LOGIQUE
        while(p1!= null && p2!=null){
            if(p1.val <p2.val){
                iteratorNode.next = p1;
                p1 = p1.next;
            }else{
                iteratorNode.next = p2;
                p2 = p2.next;
            }
            iteratorNode = iteratorNode.next;
        }
        if(p1==null){iteratorNode.next=p2;}
        if(p2==null){iteratorNode.next=p1;}
        
        return sortedHead;
    }
}
