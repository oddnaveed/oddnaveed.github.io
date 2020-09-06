---
title: Binary Tree
date: 2020-04-14 17:22:00
tags: [java, tree, dataStructure, CITS2200]
categories: [software]
top:
---

[Binary Tree](https://www.youtube.com/watch?v=H5JubkIy_p8)

[Binary Tree](https://www.youtube.com/watch?reload=9&v=BHB0B1jFKQc)

[Binary Search Tree](https://www.youtube.com/watch?v=pYT9F8_LFTM)

<!--more-->

---

^异或运算符顾名思义，异就是不同，其运算规则为1^0 = 1 , 1^1 = 0 , 0^1 = 1 , 0^0 = 0
[source](https://www.jianshu.com/p/8cf5af30f245)

---

```java [cits2200 lab standard solution]
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import CITS2200.BinaryTree;
import CITS2200.Iterator;

// complete an implementation of an abstract class of an immutable binary tree

public class BinTree extends BinaryTree<Object> {
    public BinTree() {
        super();
    }

    public BinTree(Object item, BinaryTree<Object> b1, BinaryTree<Object> b2) {
        super(item, b1, b2);
    }

    public boolean equals(Object o) {
        if ((this == null ^ o == null) || !(o instanceof BinaryTree)) {
            return false;

        }
        // casting
        BinaryTree<Object> t = (BinaryTree<Object>) o;
        if (this.isEmpty() ^ t.isEmpty()) {
            return false;
        }
        if (this.isEmpty() && t.isEmpty()) {
            return true;

        }

        return ((this.getItem().equals(t.getItem())) && (this.getLeft().equals(t.getLeft()))
                && (this.getRight().equals(t.getRight())));

    }

    public Iterator<Object> iterator() {
        return new BinaryTreeIterator(this);
    }

    class BinaryTreeIterator implements Iterator<Object> {
        private Queue<BinaryTree<Object>> q = new LinkedList<BinaryTree<Object>>();

        public BinaryTreeIterator(BinTree b) {
            if (b == null) {
                return;
            } else {
                q.add(b);
            }
        }

        public boolean hasNext() {
            return !q.isEmpty();
        }

        public Object next() {
            if (hasNext()) {
                BinTree b = (BinTree) q.remove();

                if (!b.getLeft().isEmpty()) {
                    q.add(b.getLeft());
                }

                if (!b.getRight().isEmpty()) {
                    q.add(b.getRight());
                }

                Object o = new Object();
                if (!b.isEmpty()) {
                    o = b.getItem();
                }
                return o;

            } else
                throw new NoSuchElementException("No more elements in the binary tree");
        }
    }
}
```

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

---

- external node: empty tree
- leaf: an internal node whose left and right subtrees are both empty(external nodes)
- the external nodes of a tree define its frontier
- skinny: each node has at most one child node
- complete: external nodes(and hence leaves) appear on at most two parent levels

- degree/valency: the number of vertices parent to v
- spanning: all vertices
- [induced subgraph](https://mathworld.wolfram.com/Vertex-InducedSubgraph.html)
- forest: a collection of trees
- orchard: a list(or queue) of trees

## Depth-first Traversal

- preorder: nlr
- postorder: lrn
- inorder: lnr

``` [Basic recursive depth-first search]
procedure DFS(w)
    colour[w] <- grey
    for each vertex x adjacent to w do
        if colour[x] is white then
            pi[x] <- w
            DFS(x)
        end if
    end for
    colour[w] <- black
```

``` [Non-recursive DFS]
procedure DFS(w)
    initialize stack S
    push w onto S
    while S not empty do
        x <- pop off S
        if colour[x]=white then
            colour[x] <- black
            for each vertex y adjacent to x do
                if colour[y] is white then
                    push y onto S
                    pi[y] <- x
                end if
            end for
        end if
    end while
```

```java 
public int[] getDistances(Graph g, int startVertex){
    int vNum = g.getNumberOfVertices();

    int distance[] = new int[vNum];
    for(int i=0; i<vNum; i++){
        distance[i] = -2;
    }

    int[][] matrix = g.getEdgeMatix();

    boolean checked[] = new boolean[vNum];

    Queue<Integer> q = new LinkedList<Integer>();

    queue.add(startVertex);
    checked[startVertex] = true;
    distance[startVertex] = 0;

    while(!q.isEmpty()){
        int currentVertex = q.poll();

        for(int i=0; i<vNum; i++){
            if(matrix[currentVertex][i] == 1 && checked[i] == false && !q.contains(i) && currentVertex!=i){
                distance[i] = distance[currentVertex] + 1;
                queue.add(i);
            }
        }
        checked[currentVertex] = true;
    }
    for(int i=0; i<vNum; i++){
        if(distance[i] == -2){
            distance[i] = -1;
        }
    }

    return distance;
}
```

``` [Discovery and finish times]
procedure DFS(w)
    colour[w] <- grey
    discovery[w] <- time
    time <- time+1
    for each vertex x adjacent to w do
        if colour[x] is white then
            pi[x] <- w
            DFS(x)
        end if
    end for
    colour[w] <- black
    finish[w] <- time
    time <- time+1
```


```java [Discovery and finish times]
public int[][] getTimes(Graph g, int startVertex){
    int vNum = g.getNumberOfVertices();
    int[][] times = new int[vNum][2];
    int time = 0;
    timeQueue = new LinkedList<Integer>();
    int[][] matrix = g.getEdgeMatrix();
    checked = new boolean[vNum];
    DFS(startVertex, vNum, matrix);
    return times;
}

private void DFS(int vertex, int vNum, int[][] matrix){
    timeQueue.add(vertex);

    times[vertex][0] = time;
    time++;
    for(int i=0; i<vNum; i++){
        if(matrix[vertex][i] == 1 && checked[i] == false && !timeQueue.contains(i) && vertex != i){
            timeQueue.add(i);
            DFS(i, vNum, matrix);
        }
        checked[vertex] = true;
        timeQueue
    }


}

```




## Level-order (Breath-first) Traversal

```java [Algorithm]
place tree(root window) in empty queue q
while(!q.isEmpty()){
    dequeue first item;
    if(!external node){
        visit its root node;
        enqueue left subtree(root window);
        enqueue right subtree(root window);
    }
}
```

`Time analysis`
- O(V+E): During the breath-first search, each vertex is enqueued once and dequeued once. Each enqueue and dequeue operation takes constant time, the queue manipulation takes O(V) time. At the time the vertex is dequeued, the adjacency list of that vertex is completely examined, therefore we take O(E) time examining all the adjacency lists and the total time is O(V+E).

```java
import java.util.LinkedList;
import java.util.Queue;

import CITS2200.Graph;
import CITS2200.Search;

public class SearchImp implements Search{
    int time;
    int times[][];
    Queue<Integer> timeQueue;
    boolean checked[];

    public int[] getConnectedTree(Graph g, int startVertex){
        int vNum = g.getNumberOfVertices();

        int parent[] = new int[vNum];
        for(int i=0; i<vNum; i++){
            parent[i] = -2;
        }

        int[][] matrix = g.getEdgeMatrix();

        checkd = new boolean[vNum];

        Queue<Integer> queue = new LinkedList<Integer>();

        queue.add(startVertex);
        checked[startVertex] = true;

        while(!queue.isEmpty()){
            int currentVertex = queue.poll();

            for(int i=0; i<vNum; i++){
                if(matrix[currentVertex][i] == 1 && checked[i] == false && !queue.contains(i) && !(currentVertex == i)){
                    parent[i] = currentVertex;
                    queue.add(i);
                }
            }
            checked[currentVertex] = true;
        }

        for(int i=0; i<vNum; i++){
            if(parent[i] == -2){
                parent[i] = -1;
            }
        }

        return parent;
    }
}
```

- Uses of BFS: determining whether a graph is connected, or finding the distance between two vertices

``` [BFS finding distances]
while Q is not empty
    pop vertex w from the head of the Q
    for each vertex x adjacent to w do
        if colour[x] is white then
            dist[x] <- dist[w]+1
            pi[x] <- w
            colour[x] <- grey
            push x on to the tail of Q
        end if
    end for
    colour[w] <- black
end while
```

```java [BFS finding distances]
int[] dist = new int[vNum];

while(!q.isEmpty()){
    int currentVertex = q.poll();
    for(int i; i<vNum; ++i){
        if(matrix[currentVertex][i] == 1 && !checked[i] && currentVertex != i && !q.contains(i)){
            dist[i] = dist[currentVertex] + 1;
            parent[i] = currentVertex;
            q.add(i);
        }
    }
    checked[currentVertex] = true;
}
```

## Topological sort
- classic simple application of depth-first search
- dag(directed acyclic graph): a directed graph with no directed cycles
- in a depth-first search of a dag there are no back edges
`Algorithm:`
- Apply the depth-first search procedure to find the finishing times of each vertex. When each vertex is finished, put it onto the front of a linked list. The linked list will contain the vertices in topologically sorted order.

`Time Analysis:`
- O(V+E): it takes O(V+E) time for the depth-first search, and it takes O(V) time for the manipulation of the linked list. So the total time taken is again O(V+E).


## Summary
- Searching may occur breadth first or depth first
- DFS and BFS create a spanning tree from any graph
- BFS visits the vertices nearest to the source first. It can be used to determine whether a graph is connected.
- DFS visits the vertices furthest to the source first. It can be used to perform a topological sort.
