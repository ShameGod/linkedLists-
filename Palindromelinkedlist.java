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
    public boolean isPalindrome(ListNode head) {
        if(head==null){
            System.out.println("CASE1 : the head is null");
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast !=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow is now in the middle of the map 
        ListNode tailHead = reverseList(slow);
        fast = head;
        System.out.println("the tail is " + tailHead.val );
        while(fast!=null && fast.next!=tailHead && tailHead.next!=null){
            if(fast.val != tailHead.val){
                System.out.println("CASE2 : the fase head " + fast.val + " is different from " + tailHead.val);
                return false;
            }
            System.out.println("CASEX they are both equal to : " + fast.val );
            tailHead = tailHead.next;
            fast = fast.next;
        }
        if(fast.next == tailHead && fast.val != tailHead.val){return false;}
        return true;
    }
    
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
