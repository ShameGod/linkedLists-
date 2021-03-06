/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);
        ListNode smallList;
        ListNode tallList;
        int tallLength;
        int smallLength;
        
        if(lengthA>lengthB){
            smallList = headB;tallList=headA;
            tallLength = lengthA; smallLength=lengthB;
        }else{
            smallList = headA;tallList=headB;
            tallLength = lengthB; smallLength=lengthA;
        }
        
        while(tallLength>smallLength){
            tallList = tallList.next;
            tallLength = tallLength-1;
        }
        //starting from this point the lists are in the same level
        while(tallList !=null){
            if(tallList == smallList){
                return smallList;
            }
            tallList = tallList.next;
            smallList = smallList.next;
            
        }
        return null;    
    }
    
    //get the length of a list
    public int getLength(ListNode head){
        ListNode iterator = head;
        int index = 0;
        while(iterator!=null){
            index = index + 1;
            iterator = iterator.next;
        }
        return index;
        
    }
}
