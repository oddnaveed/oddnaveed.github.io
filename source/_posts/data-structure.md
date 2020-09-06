---
title: Data Structure
date: 2020-05-25 13:56:09
tags: [dataStructure, CITS2200]
categories: [software]
top:
visible:
---

# Recursive Data Structures

## Priority Queue
- enqueue(e, p): places e in the priority queue with key p, or throws exception if k is negative. The item is placed in the front of all elements with lesser priority, but behind all others.
<!--more-->
- O(n): this operation iterates through the queue until the correct location to insert the element is found. In the worst case, the entire queue will be examined.
- examine(): returns the element at the fornt of the queue, or throws an exception if the queue is empty.
- O(1): simply returns the element at the front of the queue.
- dequeue(): removes and returns the element at the front of the queue, or throw an exception if the queue is empty.
- O(1): returns the element at the front of the queue and updates the value of front.

```java
public class PQueueLinked<E> {
    private Link<E> front;

    public PQueueLinked(){
        front = null;
    }

    private class Link<E>{
        E element;
        int priority;
        Link<E> next;
    
        public Link(E e, int p, Link<E> n){
            element = e;
            priority = p;
            next = n;
        }
    }

    public boolean isEmpty(){
        return front ==  null;
    }

    public E examine() throws Exception{
        if(!isEmpty()){
            return front.element;
        } else throw new Exception("Empty Queue");
    }

    public E dequeue() throws Exception{
        if(!isEmpty()){
            E temp = front.element;
            front = front.next;
            return temp;
        } else throw new Exception("Empty Queue");
    }

    public void enqueue(E e, int p){
        if(isEmpty() || p > front.priority){
            front = new Link<E>(e, p, front);
        } else{
            Link<E> l = front;
            while(l.next != null && l.next.priority >= p){
                l = l.next;
            }
            l.next = new Link<E>(e, p, l.next);
        }
    }
}
```


---

## Heap
- based on a binary tree.
- the key of the parent is greater than its children


### Heapify
1. compare bigger child with parent
2. swap if child is bigger than parent
3. keep comparing

`Complexity:` a balanced binary tree with n elements has a height of logn, so heapify takes at most logn changes.

### functions
- enqueue: O(logn) the key is entered at last position of the tree. Compare it with its parent and swap if it is bigger than parent. Keep comparing and in the worst case, logn changes will have to be done.
- examine: return the root of the binary tree, it has the largest key value. O(1)
- dequeue: delete the root node, move the final entry to the root position, call heapify(1) to restore the heap property. This involves a few constant time operations, together with one call to heapify. O(logn)

### Heapsort
1. create a priority queue
2. add elements into priority queue
3. create a new array to store the result
4. dequeue the elements from the priority queue to the array

```java
int[] heapSort(int[] arr){
    // create a priority queue
    PQueue pq = new PQueue();
    // add in the elements with themselves as the key
    for(int i : arr){
        pq.enqueue(i, i);
    }
    // create a new array to store the result
    int[] ans = new int[arr.length];
    // dequeue the elements from the priority queue into the ans array
    for(int i=0; i<ans.length; ++i){
        ans[i] = pq.dequeue();
    }
    return ans;
}
```





---

## Lists

```java [The Links]
class Link{
    Ojbect item;
    Link successor;

    Link(Object o, Link s){
        item = o;
        successor = s;
    }
}
```  

```java [LinkedStack]
class LinkedStack{
    Link first;

    LinkedStack(){first = null;}

    // insert at the front of the list
    void insert(Object o){
        first = new Link(o, first);
    }

    boolean isEmpty(){
        return first == null;
    }

    Object examine(){
        if (!isEmpty())
            return first.item;
    }

    void delete(){
        if(!isEmpty())
            first = first.successor;
    }

    String toString(){
        Link cursor = first;
        String s = "";
        while(cursor != null){
            s = s + cursor.item;
            cursor = cursor.successor;
        }
        return s;
    }
}
```

---

## Java LinkedList

[LinkedList](https://docs.oracle.com/javase/8/docs/api/)
<br />

```java
import java.util.LinkedList;

private LinkedList<E> list = new LinkedList<E>();

boolean offer(E e)
// adds the element as the tail

E peek()
// retrieves, but not remove the head

E peekLast()
// retrieves, but not remove the tail

E pop()
// pops an element from the stack represented by the list

void push(E e)
// pushes an element onto the stack represented by the list
```

---

## Java Queue

```java
import java.util.LinkedList;
import java.util.Queue;

private Queue<E> q = new LinkedList<E>();

q.add();  //Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions, returning true upon success and throwing an IllegalStateException if no space is currently available.
q.offer(); //Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions.
q.remove();
q.isEmpty();
q.peek();
```


---

## Map

many-to-one function(binary relation)



## instanceof usage

instanceof 是 Java 的保留关键字。它的作用是测试它左边的对象是否是它右边的类的实例，返回 boolean 的数据类型。

```java
public boolean equals(Object o) {
    if (o == null) return false;
    else if (!(o instanceof Pair)) return false;
    else return item1.equals(((Pair)o).item1) &&
                item2.equals(((Pair)o).item2); //change the type object into Pair
}
```

## toString usage

```java
public String toString(){
    return "<" + item1.toString() + "," + item2.toString() + ">";
}
// type Object -> String
```

## Set
