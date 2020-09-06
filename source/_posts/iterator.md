---
title: Iterator
date: 2020-04-14 19:10:51
tags: [dataStructure, CITS2200]
categories: [software]
top:
---

[Iterator Java Platform](https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html)

<!--more-->

```java
import java.util.Iterator

public interface Iterator<E>

boolean hasNext();

E next() throws NoSuchElementException;

void remove() throws UnsupportedOperationException;

```

```java [Iterator not the best way]
import java.util.Iterator;

public class QueueCyclic implements Queue {
    Object[] items;
    int first, last;

    public QueueCyclic(int size){
        items = newObject[size+1];
        first = 0;
        last = size;
    }

    public Iterator iterator(){
        return new BasicQueueIterator(this);
    }
}

// not an inner class
class BasicQueueIterator implements Iterator{
    private QueueCyclic backingQ;
    private int current;

    BasicQueueIterator(QueueCyclic q){
        backingQ = q;
        current = backingQ.first;
    }

    public boolean hasNext(){
        return !backingQ.isEmpty() && ((backingQ.last >= backingQ.first &&
                    current <= backingQ.last) || (backingQ.last < backingQ.first && current >= backingQ.first || current <= backingQ.last)));
    }

    public Object next(){
        if(!hasNext())
            throw new NoSuchElementException("No more elements.");
        else {
            Object temp = backingQ.items[current];
            current = (current + 1) % backingQ.items.length;
            return temp;
        }
    }

    public void remove(){
        throw new UnsupportedOperationException("Cannot remove from within queue.")
    }
}
```

---

`A better way to do:`

```java [Inner class iterator]
import java.util.Iterator;

public QueueCyclic implements Queue{
    private Object[] items;
    private int first, last;

    public QueueCyclic(int size){
        items = new Object[size+1];
        first = 0;
        last = size;
    }

    public Iterator iterator(){
        return new BasicQueueIterator();
    }

    private class BasicQueueIterator implements Iterator{
        private int current;

        private BasicQueueIterator(){
            current = first;
        }

        public boolean hasNext(){
            return !isEmpty() && ((last >= first && current <= last) ||
                        (last < first && (current >= first || current <= last)));
        }

        public Object next() throws Exception{
            if(hasNext()){
                Object temp = items[current];
                current = (current+1) % (items.length);
                return temp;
            } else throw new Exception("Empty queue");
        }
    }
}
```



```java [practice]
import java.util.Iterator;

public QueueCyclic implements Queue{
    private Object[] items;
    private int first, last;  // refer to first and last index
    
    public QueueCyclic(int size){
        items = new Object[size+1];
        first = 0;
        last = size;
    }

    public Iterator iterator(){
        return new BasicQueueIterator();
    }

    private class BasicQueueIterator implements Iterator{
        private int current;

        private BasicQueueIterator(){
            current = first;
        }

        public boolean hasNext(){
            return !isEmpty() && ((last >= first && current <= last) || 
                                    (last < first && (current >= first|| current <= last)))
        }

        public Object next() throws Exception{
            if(hasNext()){
                Object temp = items[current];
                current = (current+1) % (size+1);
                return temp;
            } else throw new Exception("Empty queue");
        }
    }
}
```

```java [using iterator]
public static void main(String[] args){
    Queue q = new QueueCyclic();
    q.enquque(new Character('p'));
    q.enqueue(new Character('a'));
    q.enquque(new Character('d'));
    q.enqueue(new Character('v'));
    Iterator it = q.iterator();
    while(it.hasNext()){
        System.out.println(it.next());
    }
}
```

---

```java [PRACTICE]
public class BinTree extends BinaryTree<Object>{
    public BinTree(){
        super();
    }

    public BinTree(Object item, BinaryTree<Object> b1, BinaryTree<Object> b2){
        super(item, b1, b2);
    }

    public boolean equals(Object o){
        if((this == null ^ o == null) || !(o instanceof BinaryTree)){
            return false;
        }

        BinaryTree<Object> t = (BinaryTree<Object>) o;
        if(this.isEmpty() ^ t.isEmpty()){
            return false;
        }

        if(this.isEmpty() && t.isEmpty()){
            return true;
        }

        return (this.getItem().equals(t.getItem())) && (this.getLeft().equals(t.getLeft())) && (this.getRight().equals(t.getRight()));
    }

    publc Iterator<Object> iterator(){
        return new BinaryTreeIterator(this);
    }
    // use a queue to store subtrees
    class BinaryTreeIterator implements Iterator<Object>{
        private Queue<BinaryTree<Object>> q = new LinkedList<BinaryTree<Object>>();

        pubic BinaryTreeIterator(BinTree b){
            if(b == null)
                return;
            else q.add(b);
        }

        public boolean hasNext(){
            return !q.isEmpty();
        }

        public Object Next(){
            if(hasNext){
                BinTree b = q.remove();

                if(!b.getLeft().isEmpty()){
                    q.add(b.getLeft());
                }

                if(!b.getRight().isEmpty()){
                    q.add(b.getRight());
                }

                Object o = new Object();
                if(!b.isEmpty()){
                    o = b.getItem();
                }
                return o;
            } else throw new NoSuchElementException("no more elements in binary tree");
        }
    }
}
```