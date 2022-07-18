# linkedLists-
All the exercices about the data structure linked lists 

## 1- Signly linked list : 

![image](https://user-images.githubusercontent.com/42012627/174730556-6753ecba-3a9d-4840-9a00-29b7d9763841.png)

```
// Definition for singly-linked list.
public class SinglyListNode {
    int val;
    SinglyListNode next;
    SinglyListNode(int x) { val = x; }
}
```

With linked lists, to get the value of an element we have to go through all the anterior elements. We have o(N) complexity with N the number of element in the linked list.

The head node is a special node, it has the tag **head** which separates it from the other nodes. 

### Complexity of adding elements in a linked list
The linked lists have a bad performence compared to arrays "o(1) to get an element" but they are quite useful to delete/ add elements.
Adding an element takes a space complexity of o(1) but a time complexity of o(N) as we need to find the prev node : 
![image](https://user-images.githubusercontent.com/42012627/174731367-863cb37b-5a95-4781-87f2-16fa19545eb4.png)

### Complexity of deleting an element in a linked list : 

![image](https://user-images.githubusercontent.com/42012627/174732244-d520315c-2784-4583-b9ad-c4908109b3ff.png)

Given this list we just need to direct the pointer of the node prev to the node next (that we can find using the cur node)
![image](https://user-images.githubusercontent.com/42012627/174732510-1713b93f-4808-485a-84ae-23518d42c92c.png)

### Exercise 1 : the design of a linked list 
My solution is available here : https://github.com/ShameGod/linkedLists-/blob/main/designLinkedList.java
The logic is quite easy here, I used a nested class (class declared inside another class) to define the bean Node, that has a value and a pointer to another node. 

### Two pointer technique for linked lists : 
![image](https://user-images.githubusercontent.com/42012627/175356269-a374dc59-e115-4bfe-9e96-3feae220aedc.png)
https://github.com/ShameGod/linkedLists-/blob/main/twoPointerTechnique.java
Space complexity = o(1) 
It is a way to find out if a Linked list is a cycle or not.
The first pointer P1 will move every 5 loops while the P2 moves every time. P2 iterates over the linked list faster than P1, if P1 reaches P2 at some point, it means that the List is a cycle. If P2 has a value null, it means that he reached the end of the list and the listy is not a cycle. If P2 points to the same value as P1 it means that the linked list is a cycle. The time complexity here is o(N), with N the number of elements in the linked List. 

**notice** we could have used hashmaps, but the space complexity would have been o(n) instead of o(1) 

two pointer technique template
```
// Initialize slow & fast pointers
ListNode slow = head;
ListNode fast = head;
/**
 * Change this condition to fit specific problem.
 * Attention: remember to avoid null-pointer error
 **/
while (slow != null && fast != null && fast.next != null) {
    slow = slow.next;           // move slow pointer one step each time
    fast = fast.next.next;      // move fast pointer two steps each time
    if (slow == fast) {         // change this condition to fit specific problem
        return true;
    }
}
return false;   // change return value to fit specific problem
```

### Get the intersection of two linked lists 

https://github.com/ShameGod/linkedLists-/blob/main/intersectionOfTwoLists.java
Space complexity o(1) and time complexity of o(n)

### Remove the nth Element 
https://github.com/ShameGod/linkedLists-/blob/main/removeNthNode.java

The key here is to treat all the cases and be careful to pay attention to details (index). I tried all the cases on a paper before finding it out


**Note**: always check two things with linked lists : 
       + that the node is not null before calling the node.next, it might cause a NPE
       + check the conditions of a loop to not endup with an infinit loop

### Odd and even linked list : 

We solve the problem here using a genius technique, we devide the linked list by two. a first linkedlist of even elements and another one of odd elements. At the end we link the tail of the first one with the head of the second

### Palindrome dor linked lists : 
We will resolve this in two steps : 

* first the slow/ fast pointer technique : 
We will move the fist pointer by one and the other by two. At the end the slow pointer will be in the middle of the linked list.
* then we revert the list starting from the middle (slow).
After we compare the values one after the other

## Useful tips for linked lists : 


It is not easy to debug when using a linked list. Therefore, it is always useful to try several different examples on your own to validate your algorithm before writing code.
 

