/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head==null){return null;}
        flatenRecursive(head); 
        return head;
    }
    
    public void flatenRecursive(Node head){
        Node iterator = head;
        while(iterator!=null){
            Node next = iterator.next;
            if(iterator.child != null){
                Node temp = iterator.child;
                iterator.next = iterator.child;
                iterator.child = null;                
                flatenRecursive(temp);
            }
            if(iterator.next == null){
                iterator.next = next;
            }
            
            iterator = iterator.next;
        }
    }
    
}
