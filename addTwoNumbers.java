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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //Init conditions 
        if(l1==null && l2==null){return null;}
        // reverse the two lists 
        ListNode reversedList1 = reverseList(l1);
        ListNode reversedList2 = reverseList(l2);
        //parse the two lists
        String parseL1 = parse(reversedList1);
        String parseL2 = parse(reversedList2);
        //add the two list 
        long intResult = Long.parseLong(parseL1) + Long.parseLong(parseL2);
        //build the result list
        return reverseList(listOf(String.valueOf(intResult)));
    }
    
    public ListNode listOf(String str){
        ListNode result = new ListNode(0);
        ListNode iterator = result;
        String[] substrings = str.split("");
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            iterator.val = Character.getNumericValue(ch[i]);
            if(i!=ch.length-1){
                iterator.next = new ListNode(0);
                iterator = iterator.next;
            }
        }
        return result;
    }
    
    public String parse(ListNode list){
        ListNode iterator = list;
        String result ="";
        if(iterator==null){return null;}
        while(iterator!=null){
            result = result + String.valueOf(iterator.val);
            iterator = iterator.next;
        }
        return result;
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
