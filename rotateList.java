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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null){return null;}
        k = k%getLength(head);
        return recursiveRotate(head, k);
    }
    private ListNode recursiveRotate(ListNode head, int k){
        if(k==0){return head;}
        ListNode beforeLast = findBeforeLast(head); 
        if(beforeLast.next == null){return head;} // if we have only one element
        beforeLast.next.next = head;
        head = beforeLast.next;
        beforeLast.next = null;
        return recursiveRotate(head, k-1);
    }
    
    private ListNode findBeforeLast(ListNode head){ //head can't be null
        ListNode iterator = head;
        while(iterator.next != null && iterator.next.next != null){
            iterator = iterator.next;
        }
        return iterator;
    }
    
    private Integer getLength(ListNode head){
        Integer i = 0;
        ListNode iterator = head;
        while(iterator !=null){
            i = i +1;
            iterator = iterator.next;
        }
        return i;
    }
}
