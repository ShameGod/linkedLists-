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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode iterator1 = head;
        ListNode iterator2 = moveIterator(head, n);
        
        if(isTail(iterator1)){System.out.print("CASE 1"); return null;}
        else if(iterator2==null){head = iterator1.next;System.out.print("CASE 2"); return head;}
        
        while(iterator2.next !=null){
            iterator2 = iterator2.next;
            iterator1 = iterator1.next;
        }
        
        if(nextElementIsTail(iterator1)){iterator1.next = null;System.out.print("CASE 3");}
        else {iterator1.next = iterator1.next.next;System.out.print("CASE 4");}
        return head;
    }
    
    public boolean nextElementIsTail(ListNode list){
        return list.next.next==null;
    }
    
    public boolean isTail(ListNode list){
        return list.next==null;
    }
    
    public ListNode moveIterator(ListNode head, int n){
        ListNode iterator = head;
        int index = 0;
        while(index<n){
            iterator = iterator.next;
            index = index+1;
        }
        return iterator;
    }
}
