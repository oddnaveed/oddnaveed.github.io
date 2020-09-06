---
title: Stack
date: 2020-06-11 17:44:46
tags: [dataStructure, CITS2200]
categories: [software]
top:
visible:
---

## A List of Stacks

```java [baisc recursive stack]
public class LinkedStack{
    private Link first;

    public LinkedStack(){
        first = null;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void insert(Object o){
        first = new Link(o, first);
    }

    public Object examine() throws Exception{
        if(!isEmpty()){
            return first.item;
        } else throw new Exception("empty list");
    }

    public void delete() throws Underflow{
        if(!isEmpty()){
            first = first.successor;
        } else throw new Underflow("empty list");
    }
}
```

<!--more-->

```java
import CITS2200.*; 

public class ListLinked implements CITS2200.List{
    private Link before;
    private Link after;

    public ListLinked(){
        after = new Link(null, null);
        before = new Link(null, after);
    }

    private class Link{
        private Object item;
        private Link successor;

        public Link(Object e, Link s){
            item = e;
            successor = s;
        }
    }

    private class WindowLinked{
        private Link link;

        public WindowLinked(){
            link = new Link(null, null);
        }
    }


    public boolean isEmpty(){
        return before.successor == after;
    }

    public boolean isBeforeFirst(WindowLinked w){
        return w.link == before;
    }

    public boolean isAfterLast(WindowLinked w){
        return w.link == after;
    }

    /**
     * 
     * @param w
     * @return
     * @throws OutOfBounds if w is over the before first or after last postiion,
     * otherwise deletes and returns the element under w, and places w over the next element
     */
    public Object delete(WindowLinked w) throws OutOfBounds{
        if(isBeforeFirst(w) || isAfterLast(w)){
            throw new OutOfBounds("cannot delete at this point");
        }
        Object item = w.link.item;
        Link next = w.link.successor;
        w.link.item = next.item;
        w.link.successor = next.successor;
        if(next == after){
            after = w.link;
        }
        return item;
    }

    /**
     * throws an exeption if w is over the before first or after last position,
     * otherwise repalces the element under w with e and returns the old element
     */
    public Object replace(Object e, WindowLinked w) throws OutOfBounds{
        if(isBeforeFirst(w) || isAfterLast(w))
            throw new OutOfBound("cannot replace at this point");
        Object item = w.link.item;
        w.link.item = e;
        return item;
    }

    public Object examine(WindowLinked w) throws OutOfBounds{
        if(isBeforeFirst(w) || isAfterLast(w))
            throw new OutOfBounds("cannot retrieve data here");
        return w.link.item;
    }

    /**
     * 
     * @param e
     * @param w
     * @throws OutOfBound if w is over the before first position
     * otherwise insert an element before w
     */
    public void insertBefore(Object e, WindowLinked w) throws OutOfBound{
        if(isBeforeFirst(w))
            throw new OutOfBound("cannot insert before this point");
        w.link.successor = new Link(w.link.item, w.link.successor);
        if(isAfterLast(w))
            after = w.link.successor;
        w.link.item = e;
        w.link = w.link.successor; // move the window pointer back to original place
    }

    /**
     * throws OutOfBound if w is over after last position
     * otherwise insert an element after w
     */
    public void insertAfter(Object e, WindowLinked w) throws OutOfBound{
        if(isAfterLast(w))
            throw new OutOfBound("cannot insert after this point");
        w.link.successor = new Link(e, w.link.successor);
    }

    /**
     * 
     * @param w
     * @throws OutOfBounds if w is over before first position,
     * otherwise move w to the previous window position
     */
    public void previous(WindowLinked w) throws OutOfBounds{
        if(isBeforeFirst(w))
            throw new OutOfBound("w is the start of the list");
        Link current = before;
        while(current.successor != w.link){
            current = current.successor;
        }
        w.link = current;
    }

    /**
     * @throws OutOfBounds if w is over after last position
     * otherwise move w to the next window posiiton
     */
    public void next(WindowLinked w) throws OutOfBounds{
        if(isAfterLast(w))
            throw new OutOfBound("w is the end of the list");
        w.link = w.link.successor;
    }

    /**
     * initialises w to the after last position
     */
    public void afterLast(WindowLinked w){
        w.link = after;
    }

    /**
     * initialises w to the before first position
     * @param w
     */
    public void beforeFirst(WindowLinkded w){
        w.link = before;
    }

    public String toString(){
        String a = "";
        Link current = before;
        while(current != null){
            a += current.item + ",";
            current = current.successor;
        }
        return a;
    }
}
```


## Stack Block

```java
import CITS2200.Overflow;
import CITS2200.Stack;
import CITS2200.Underflow;

public class StackBlock implements Stack{
	private int s; 
	private Object[] stack; 
	private int top; 

	
	public StackBlock(final int s) {
		if (s < 1) {
			throw new IllegalArgumentException("Max Elements cannot be less than 1, was: " + s);			
		}
		this.s = s;
		stack = new Object[s];
		top = 0;
	}


	public boolean isEmpty() {
		return (top == 0);
	}
	
	public boolean isFull() {
		return (top >= stack.length);
	}
	
	
	public void push(Object o) throws Overflow {
		if (isFull()) {
			throw new Overflow("the stack is full");
		}
		stack[top] = o;
		top++;

	}
	
	public Object examine() throws Underflow {
		if (isEmpty()) {
			throw new Underflow("the stack is empty");
		}
		else {
			return stack[top-1];
		}	
	}
	
	
	public Object pop() throws Underflow {
		if (!isEmpty()) {
			top--;
			return (stack[top]);
		}
		else throw new Underflow("the stack is empty");	
	}
}
```

```java practice
public void insertBefore(Object e, WindowLinked w) throws Exception{
    if(isBeforeFirst(w))
        throw new Exception("cannot insert before beforeFirst position");
    w.link.successor = new Link(w.link.item, w.link.successor);
    if(isAfterLast(w)){
        after = w.link.successor;
    }
    w.link.item = e;
    w.link = w.link.successor; // move the window pointer back to original position
}


public Object examine() throws Exception{
    if(isEmpty()){
        throw new Exception()
    }
}

//dfs to find distance

while(!q.isEmpty()){
    int currentVertex = q.poll();
    
    for (int i=0; i<vNum; i++){
        if(matrix[currentVertex][i]==1 && checked[i]==false && !q.contains(i)){
            distance[i] = distance[currentVertex] + 1;
            q.add(i);
        }
    }

}
```