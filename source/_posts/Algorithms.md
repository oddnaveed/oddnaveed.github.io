---
title: Algorithms
date: 2020-05-22 11:29:07
tags: [dataStructure, algorithm, CITS2200]
categories: [software]
top:
visible:
---

`Benchmark`:do it experimentally by measuring the number of seconds it takes for a program to run<br />
`Complexity`: number of operations <br />
`n`: size of input <br/>

<!--more-->

---

## Insertion Sort

```[pseudo code]
procedure INSERTION-SORT(A)
1    for j<-2 to length[A]
2        do key <- A[j]
3        i = j-1
4        while i>0 and A[i]>key
5            do A[i+1] <- A[i]
6                i = i-1
7        A[i+1] <- key
```

Line 2-7 will be executed n times.(under for loop), lines 4-5 will be executed up to j times for j=1 to n.<br />
O(n^2)

<br />

```java
	public void insertionSort(long[] a)
    	{
			int n = a.length;
    		for (int j = 1; j<n; j++)
    		{
    			long key = a[j];
    			int i = j-1;

    			while (i>=0 && a[i] > key)
    			{
    				a[i+1] = a[i];
    				i = i-1;
    				//count++;
    			}
    			a[i+1] = key;
    		}
		}
```

---

## Merge Sort

[Merge Sort](https://www.tutorialspoint.com/data_structures_algorithms/merge_sort_algorithm.htm)

- Better in time
- O(nlogn)

`Explain`

1. divide the array recursively into equally small arrays until it can no longer be divided. O(logn) steps -- the size of the array is reduced to half of its original size in each step
2. merge the arrays progressively into larger and larger arrays. Suppose we are given two arrays of length k, we need to merge them into a sorted array of length 2k. walk simultaneously along the two arrays, comparing elements and inserting the elements at the correct position in the array of length 2k. The complexity of merging is O(n) at each level
since there are logn levels, the total complexity -> O(nlogn) 

<br/>

[`Complexity`](https://www.youtube.com/watch?v=g1AwUYauqgg)

```
T(n) = 2T(n/2) + n;
     = 2^2T(n/2^2) + 2n;
     = 2^3T(n/2^3) + 3n;
     = 2^iT(n/2^i) + in;
we know T(1) = 1
let n/(2^i) = 1
    n = 2^i
    logn = i
T(n) = nT(1) + nlogn
     = n + nlogn
     = O(nlogn)
```
<br />

```
procedure MERGE-SORT(A, p, r)
    if p<r then
        q <- [(p+r)/2]
        MERGE-SORT(A,p,q); MERGE-SORT(A, q+1, r); MERGE(A, p, q, r)

procedure MERGE(A, p, q, r)
    n1 <- q-p+1; n2 <- r-q
    for i<-1 to n1 do L[i]<-A[p+i-1]
    for j<-1 to n2 do R[j]<-A[q+j]
    i<-1; j<-1; k<-p
    while i<= n1 and j<=n2 do
        if L[i]<=R[j] then A[k++]<-L[i++]
        else A[k++] <- R[j++]
    while i<=n1 do A[k++] <- L[i++]
    while j<=n2 do A[k++] <- R[j++]
```

<br />

```java
	public void mergeSort(long[] a){
	    mergeSort(a, 0, a.length-1);
	}

	private void merge(long[] a, int p, int q, int r)
	{
	    int n = q-p+1;
	    int m = r-q;
        long[] an = new long[n];
        long[] am = new long[m];
        for(int i = 0; i<n; i++) {
            an[i] = a[p+i];
            //count++;
	    }
        for(int i = 0; i<m; i++){
            am[i] = a[q+i+1];
            //count++;
	    }
        int i = 0;
        int j = 0;
        for(int k = p; k<=r; k++){
            if(i==n) a[k] = am[j++];
            else if(j==m || an[i]<am[j]) a[k] = an[i++];
            else a[k] = am[j++];
            // count++;
        }
	}

	private void mergeSort(long[] a, int p, int r)
	{
        if(p<r){
            int i = (p+r)/2;
            mergeSort(a,p,i);
            mergeSort(a,i+1,r);
            merge(a, p,i,r);
        }
	}

```

---

## Quick Sort

[Quick Sort](https://www.tutorialspoint.com/data_structures_algorithms/quick_sort_algorithm.htm)
[Quicksort](https://www.geeksforgeeks.org/quick-sort/)

- better in space
- worst case O(n^2)
- average case O(nlogn)

`Explain`

1. pick the last element as pivot
2. partition the array using pivot value, put all smaller elements before pivot, put all greater elements after pivot
3. quicksort left partition and right partition recursively

<br />

`Complexity`
Analysis of QuickSort
Time taken by QuickSort in general can be written as following.
T(n) = T(k) + T(n-k-1) + O(n)
The first two terms are for two recursive calls, the last term is for the partition process. k is the number of elements which are smaller than pivot.
The time taken by QuickSort depends upon the input array and partition strategy. Following are three cases. <br />

**Worst Case**: The worst case occurs when the partition process always picks greatest or smallest element as pivot. If we consider above partition strategy where last element is always picked as pivot, the worst case would occur when the array is already sorted in increasing or decreasing order. Following is recurrence for worst case.

```
T(n) = T(0) + T(n-1) + O(n)
which is equivalent to
T(n) = T(n-1) + O(n)
The solution of above recurrence is O(n^2).
```

<br />

**Average Case**:
This occurs when a pivot value is picked, the pivot position is averagely in the middle. If each pivot picked is approximately in the middle, the comparisons are halved because the left side of the pivot no need to be compared to the right side of the pivot. This has to be done n times for each pivot picked, so the total complexity is O(nlogn)

<br />

Although the worst case time complexity of QuickSort is O(n^2) which is more than many other sorting algorithms like Merge Sort and Heap Sort, QuickSort is faster in practice, because its inner loop can be efficiently implemented on most architectures, and in most real-world data. QuickSort can be implemented in different ways by changing the choice of pivot, so that the worst case rarely occurs for a given type of data. However, merge sort is generally considered better when data is huge and stored in external storage.

```
procedure QUICKSORT(A, p, r)
    if p<r
        then q<-PARTITION(A, p, r)          // pivot
            QUICKSORT(A, p, q-1); QUICKSORT(A, q+1, r)      //pivot两边再sort

procedure PARTITION(A, p, r)
    x<-A[r]; i<- p-1    // choose last index as pivot
    for j<-p to r-1
        do if A[j]<=x
            then i <-i+1
                exchange A[i] <-> A[j]
    exchange A[i+1]<->A[r]
    return i+1
```

<br />

```java
	public void quickSort(long[] a){
		quickSort(a, 0, a.length-1);
	}

	private void quickSort(long[] a, int p, int r) {
		if (p<r) {
			int pi = partition(a, p, r);
			quickSort(a, p, pi-1);
			quickSort(a, pi+1, r);
		}
	}

	private int partition(long[] a, int p, int r) {
		long pivot = a[r];
		int low = (p-1);
		for (int j = p; j<=(r-1); j++) {
			if (a[j] <= pivot) {
				low++;
				long temp = a[low];
				a[low] = a[j];
				a[j] = temp;
			}
			count++;
		}

		long temp = a[low+1];
		a[low+1] = a[r];
		a[r] = temp;

		return low+1;
	}
```

## Prim's Algorithm

Minimum Cost Spanning Tree (greedy algorithm) <br />
Priority first search <br/>
`Theory`

- O(ElogV)
- from tree to spanning
1. initialize the minimum spanning tree with a vertex chosen randomly
2. find all edges connected to the current tree and add them into a priority queue
3. dequeue the priority queue we get the minimum weight edge connected to the tree
4. repeating above steps until the tree gets spanning

- to get the minimum weight edge, we use min heap as a priority queue. Each dequeue from the heap takes O(logV)
- E edges -> the overall complexity is O(ElogV)

<br />

`Implementation`

- use PriorityQueue<Node>
- use colour[] to define visited or not
- use parent[] to save parent vertex infomation
- use distance[] to save the cost of each edge

1. add start vertex to priority queue
2. while priority queue not empty, remove one, and checked if the vertex has been visited
3.

```java
import CITS2200.Path;
import CITS2200.Graph;
import java.util.*;
import java.util.PriorityQueue;

/**
 * The aims of this labsheet are to:
 *
 * 1.Apply Prim's algorithm to find a minimum spanning tree of an undirected,
 * weighted graph.
 *
 * 2.Apply Dijkstra's algorithm to find the shortest paths from a source vertex
 * in a directed, weighted graph.
 */
public class PathImp implements Path {

    /**
     * constructor for clss PathImp
     */
    public PathImp() {

    }

    /**
     * implementation of getMinimumSpanningTree should return the weight of the
     * minimum spanning tree, or -1 if no minimum spanning tree can be found Prim's
     * Algorithm
     */
    public int getMinSpanningTree(Graph g) {
        int numOfVert = g.getNumberOfVertices();
        if (numOfVert == 0) {
            throw new IllegalArgumentException("empty graph");
        }
        int[] colour = new int[numOfVert]; // represent visited or not
        int[] parent = new int[numOfVert];
        Arrays.fill(parent, -1); // parents unknown

        int[] distance = new int[numOfVert]; // distance of child vertex to parent vertex
        Arrays.fill(distance, -1);
        distance[0] = 0;

        int[][] edgeWeight = g.getEdgeMatrix();

        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.add(new Node(0, 0)); // the start vertex(randomly pick up)

        while (!pq.isEmpty()) {
            int vertex = pq.remove().node;
            if (colour[vertex] != 0) { // case: visited
                continue;
            }
            colour[vertex] = 1;

            for (int i = 0; i < numOfVert; ++i) {
                int weight = edgeWeight[vertex][i];
                if (weight > 0 && colour[i] == 0) {
                    if (distance[i] == -1 || distance[i] > weight) {
                        distance[i] = weight;
                        parent[i] = vertex;
                        pq.add(new Node(i, distance[i]));
                    }
                }
            }
        }

        int totalWeight = 0;
        for (int d : distance) {
            if (d == -1) { // if there's one vertex hasn't been visited
                totalWeight = -1;
                break;
            }
            totalWeight += d;
        }
        return totalWeight;
    }


    class Node implements Comparable<Node> {
        public int node;
        public int cost; // represent priority value- the smaller the higher priority

        public Node() {

        }

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node n) {
            if (cost < n.cost) {
                return -1;
            } else if (cost > n.cost) {
                return 1;
            } else
                return 0;
        }
    }

}

```

## Djikstra's Algorithm

Shortest path (non-negative weight) <br />
`Theory`
- single-source shortest path algorithm
- O(ElogV)

1. a heap is built by inserting all the vertices with priority of infinity except the priority of source vertex s as 0
2. deque the vertex at the root of the heap. s will be dequeued first as it has minimum priority. Then the priorities of all the vertices adjacent to s are relaxed. Relaxation is to replace the current priority with the shortest path from the source vertex. The vertices adjacent to s will have priority less than infinity, one of them will be at the root after the heapify operation. When a vertex is selected at the root of the heap, all its adjacent vertices are relaxed. The algorithm has a complexity O(ElogV) as each edge is selected once and the heapify operation due to relaxation takes O(logV) time for each vertex.

<br/>

`Complexity` O(ElgV) <br/>
To find shortest path in a graph has no negative edge weights, simply make V runs of the algorithm: O(VElgV).

<br/>

`Relaxation`

```java
if(d[u] + c(u,v) < d[v])
    d[v] = d[u] + c(u,v);
```

`Implementation`

- Priority first search
- PriorityQueue<Node>
- colour[] represents visited or not
-

<br />

```java
import CITS2200.Path;
import CITS2200.Graph;
import java.util.*;
import java.util.PriorityQueue;

/**
 * The aims of this labsheet are to:
 *
 * 1.Apply Prim's algorithm to find a minimum spanning tree of an undirected,
 * weighted graph.
 *
 * 2.Apply Dijkstra's algorithm to find the shortest paths from a source vertex in a directed, weighted graph.
 */
public class PathImp implements Path {

    /**
     * constructor for clss PathImp
     */
    public PathImp() {

    }

    /**
     * implementation of getShortestPaths(G, v) should use Djikstra's algorithm to
     * return an array of the distances from the specified start vertex to each of
     * the vertices in the graph.
     *
     * Djikstra's Algorithm
     *
     * @param int v - start vertex
     */
    public int[] getShortestPaths(Graph G, int startVertex) {
        int numOfVert = G.getNumberOfVertices();

        if (numOfVert == 0) {
            throw new IllegalArgumentException("empty graph");
        }
        int[] colour = new int[numOfVert];
        int[] parent = new int[numOfVert];
        Arrays.fill(parent, -1);// initialize parent array

        int[] distance = new int[numOfVert]; // distance of the child vertex to parent vertex
        Arrays.fill(distance, -1); // initialize to infinity
        distance[startVertex] = 0;

        int[][] edgeWeight = G.getEdgeMatrix();

        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.add(new Node(startVertex, distance[startVertex]));
        // 1st element-vertex index, 2nd element - distance to
        // start vertex

        while (!pq.isEmpty()) {
            int vertex = pq.remove().node;
            if (colour[vertex] != 0) { // visited
                continue;
            }

            for (int i = 0; i < numOfVert; ++i) {
                int weight = edgeWeight[vertex][i];
                if (weight > 0 && colour[i] == 0) {
                    if (distance[i] == -1 || distance[i] > distance[vertex] + weight) {
                        distance[i] = distance[vertex] + weight;
                        parent[i] = vertex;
                        pq.add(new Node(i, distance[i]));
                    }
                }
            }

            colour[vertex] = 1; // now set to visited
        }
        return distance;
    }

    class Node implements Comparable<Node> {
        public int node;   // set it to public so it can be assessed later by parameter
        public int cost;

        public Node() {

        }

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node n) {
            if (cost < n.cost) {
                return -1;
            } else if (cost > n.cost) {
                return 1;
            } else
                return 0;
        }
    }
}
```

---

## Bellman-Ford Algorithm
- negative weight edges
- O(E(V-1) + E) = O(EV)
- check E edges for a total V-1 times, then check if it contains negative weight cycles

1. calculate the shortest paths with at most one edge in the path
2. calculate the shortest paths with at most 2 edges, and so on
3. after the i-th iteration, the shortest paths with at most i edges are calculated
4. there can be maximum V-1 edges in any simple path, so the relaxation runs V-1 times, and takes O(E(V-1))
5. use a failure check loop to check if we can relax it. If we can still relax it then there exists negative weight cycle. Since there are e edges, the loop takes O(E)

---

## Floyd-Warshall Algorithm
- dynamic programming
- all-pairs shortest path
- O(V^3)
- If d[i][j] maxtrix is the shortest path between a pair of vertices i and j, this algorithm computes the shortest paths between all pair of vertices passing through a set of vertices {1...k}. d[i][j][0] is the path that does not go through any other vertices which is the adjacency matrix with weights of edges. When the k+1 vertex is included, we check whether the shortest path passing through the k+1 vertex improves the previously-stored shortest path. We potentially update a matrix of size V^2 when we include a new vertex, and there are V vertices, the complexity is O(V^3)

---

## Kruskal's Algorithm 
- Kruskal's maintains a forest
- forest -> spanning
- O(ElogE)
1. choose the minimum weight edges that have not yet been added to the forest. This can be done by sorting the E edges in ascending order by using an optimal sorting algorithm(e.g. mergesort) in O(ElogE) time.
2. check if it remains a forest and no cycles are introduced. If two vertices of an edge are in different trees then no cycles will be introduced. This is done by checking whether the two vertices of an edge are in different partition. This is done through maintaining a disjoint sets forest. The complexity of each lookup is O(logV), since there are E edges, the complexity of this lookup is O(ElogV)

---

## Breadth-First Search Algorithm
- O(V+E)
- We add the root node into an empty queue. While the queue is not empty, we dequeue the first vertex, and if it's not an external node, we enqueue its left and right subtree.
- Each vertex is enqueued and dequeued once. Each enqueue and dequeue operation takes constant time, so the total queue manipulation takes O(V). When a vertex is dequeued, its adjacency list will be fully examined, therefore we take O(E) time examining all the adjacency lists and the total time is O(V+E).


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
- O(V+E): During the breadth-first search, each vertex is enqueued once and dequeued once. Each enqueue and dequeue operation takes constant time, the queue manipulation takes O(V) time. At the time the vertex is dequeued, the adjacency list of that vertex is completely examined, therefore we take O(E) time examining all the adjacency lists and the total time is O(V+E).

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

---

## Depth-First Search

- preorder: nlr
- postorder: lrn
- inorder: lnr

`Theory`
- When DFS(w) is called, we initialise a stack S, push w onto the stack, while !empty, we pop off one verrtex from S, for each unvisited adjacent vertex, we add it onto the stack.
- O(V+E)
- For each vertex run the routine DFS(w) once, the routine only contains constant time array assesses, so it takes O(V). The adjacency lists of each vertex are fully examined, which takes O(E) in total. So O(V+E)


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
        timeQueue.poll();
        times[vertex][1] = time;
        time++;
    }
}
```

---


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
