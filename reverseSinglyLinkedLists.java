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
    public ListNode reverseList(ListNode head) {
        if(head == null){return null;}
        ListNode prev = null;
        ListNode cur = head;
        head = head.next;
        return recursiveReverseList(prev,cur,head);
    }
    
    public ListNode recursiveReverseList(ListNode prev, ListNode cur, ListNode head)
    {
        if(head == null)
        {
            cur.next =prev;
            return cur;
        }
        head = cur.next;
        cur.next = prev;
        return recursiveReverseList(cur, head, head.next);
    }
}
