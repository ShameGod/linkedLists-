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
The first pointer P1 will move every 5 loops while the P2 moves every time. P2 iterates over the linked list faster than P1, if P1 reaches P2 at some point, it means that the List is a cycle. If P2 has a value null, it means that he reached the end of the list and the listy is not a cycle. If P2 points to the same value as P1 it means that the linked list is a cycle. The complexity here is o(N), with N the number of elements in the linked List. 
