/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    HashMap<Node, Node> hashMap = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head==null){return null;}
        Node mediumHead = firstCopy(head);
        return secondCopy(mediumHead, head, hashMap);
    }
    
    private Node secondCopy(Node newHead, Node oldHead, HashMap<Node,Node> hashMap){
        Node oldIterator = oldHead;
        Node newIterator = newHead;
        while(oldIterator != null){
            if(oldIterator.random == null){
                oldIterator = oldIterator.next;
                newIterator = newIterator.next;
                continue;
            }
            newIterator.random = hashMap.get(oldIterator.random);
            oldIterator = oldIterator.next;
            newIterator = newIterator.next;
        }
        return newHead;
    }
    
    private Node firstCopy(Node head){
        Node newHead = new Node(head.val);
        Node newIterator = newHead;
        hashMap.put(head, newHead);
        Node iterator = head.next;
        while(iterator!=null){
            Node newNext = new Node(iterator.val);
            newIterator.next = newNext;
            hashMap.put(iterator, newNext);
            newIterator = newIterator.next;
            iterator = iterator.next;
        }
        return newHead;
    }
}
