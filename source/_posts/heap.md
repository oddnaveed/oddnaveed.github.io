---
title: Priority Queue and Heap Sort
date: 2020-05-05 13:17:58
tags: [dataStructure, heap, priorityQueue, CITS2200]
categories: [software]
top:
visible:
---

[Heap Deque](https://www.youtube.com/watch?v=ijfPvX2qYOQ)


`Heap`
- based on a binary tree.
- the key of the parent is greater than its children

<!--more-->

## Heapify
1. compare bigger child with parent
2. swap if child is bigger than parent
3. keep comparing

`Complexity:` a balanced binary tree with n elements has a height of logn, so heapify takes at most logn changes.

## functions
- enqueue: O(logn) the key is entered at last position of the tree. Compare it with its parent and swap if it is bigger than parent. Keep comparing and in the worst case, logn changes will have to be done.
- examine: return the root of the binary tree, it has the largest key value. O(1)
- dequeue: delete the root node, move the final entry to the root position, call heapify(1) to restore the heap property. This involves a few constant time operations, together with one call to heapify. O(logn)

`dequeue()`

1. delete the root node
2. move the final entry to the root position
3. call heapify
   1. - compare the bigger child with parent
   2. - swap if needed
   3. - (keep comparing) (maximum exchange logn -- the height of the heap/balanced binary tree property)


## Heapsort
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



