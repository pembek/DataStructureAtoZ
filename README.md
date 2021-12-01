A cheat sheet or a learning material for those who have just started to practice things with data structures.

Covered data structures will be listed accordingly. For now:

* Binary Tree
* Binary Search Tree
* Stack
* Deque
* Priority Queue(elementary or best: impl.with binary heap)
    * ![img_3.png](img_3.png)
    * ![img_4.png](img_4.png)
* Binary Heap
* Red Black tree
//* Elementary Symbol Tables( with unordered Linkedlist O(N) search, O(N) insert, )
//* Elementary Symbol Tables( keep ordered 2 arrays, logn binary search time, insert time O(N), move everything)
//* Elementary Symbol Tables( using BST includes key, value. Sorted by key. logN BST search time, insert logn in average, inorder O(N))
//Balanced Search Trees
 * 2-3 Search trees (Guaranteed logarithmin performance for search and insert)
 * left leaning red-black BSTs (1979 , 2007)
 * B-tree (generalization)

![img_7.png](img_7.png)
![img_8.png](img_8.png)
![img_9.png](img_9.png)


Some of the sources that are used:
http://cslibrary.stanford.edu/110/BinaryTrees.html

**SORT ALGORITHMS** in class SortLibrary:

![img_6.png](img_6.png)

* **BASIC SORT ALGORITHMS**

  * **SELECTION SORT**  time complexiy: O(N^2)
![img.png](img.png)
  
  * **INSERTION SORT**  time complexiy: O(N^2)
    * If the array is partially sorted it runs on linear time O(N)
![img_1.png](img_1.png)
      
  * **SHELL SORT** time complexiy: O(N^3/2) - in practice it is much less, but not proved
  Nearly same as insertion sort but;
  (the idea: move entries more than 1 position at a time by h-sorting the array)
    
  * **HEAP SORT**
   * ![img_5.png](img_5.png)
* **ADVANCED SORT ALGORITHMS**
  * **MERGE SORT**  O(N LOGN)
  * **QUICK SORT**  O(N LOGN)
  

**SELECTION ALGORITHMS**


Selecting sort algorithm criteria cheat sheet:

Applications can have diverse attributes:
* Stable?
* Parallel?
* Deterministic?
* Keys all distinct?
* Multiple key types?
* Linked list or arrays?
* Large or small items?
* Is your array randomly ordered?
* Need guaranteed performance?

![img_2.png](img_2.png)