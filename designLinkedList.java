class MyLinkedList {
    
    class Node{
        public int val;
        public Node next;
        
        public Node(int val){
            this.val = val;
        }
    }

    private Node headNode;
    public MyLinkedList() {}
    
    public int get(int index) {
        return getNodeIndex(index).val;
    }

    
    public Node getNodeIndex(int index){
        Node iteratorNode = headNode;
        int index2 = 0;
        if(iteratorNode == null){return null;}
        while(index2<=index){
            iteratorNode = iteratorNode.next;
            System.out.println("GET:  at index "+ index2 + " : " + iteratorNode.val );
            if(iteratorNode == null){
                return null;
            }
            index2 = index2 + 1;
        }
        return iteratorNode;
    }

    public void addAtHead(int val) {
        Node cur = new Node(val);
        cur.next = headNode;
        headNode = cur;
        System.out.println("ADD HEAD: added atHead : " + val );
    }
    
    public void addAtTail(int val) {
        Node cur = new Node(val);
        Node lastNode = getTail();
        lastNode.next = cur;
        System.out.println("ADD TAIL: added at tail : " + val );
        
    }
    
    public Node getTail(){
        Node iteratorNode = headNode;
        while(iteratorNode.next!=null){iteratorNode=iteratorNode.next;}
        return iteratorNode;
    }
    
    public void addAtIndex(int index, int val) {
        Node cur = new Node(val);
        Node prev = getNodeIndex(index-1);
        if(prev == null){return;}
        if(prev.next==null){addAtTail(val);}
        cur.next = prev.next;
        prev.next = cur;
        System.out.println("ADD INDEX: added at index "+ index + " : " + val );
    }
    
    public void deleteAtIndex(int index) {
        Node cur = getNodeIndex(index-1);
        if(cur == null || cur.next == null){return;}
        if(cur.next.next == null){cur.next=null;}
        System.out.println("DELETE: deleted the index  : " + index + " with the value " + cur.next.val);
        cur.next = cur.next.next;
        System.out.println("DELETE: the next element is now  : " + cur.next.val );
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
