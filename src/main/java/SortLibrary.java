import java.util.Iterator;
import java.util.Random;

public class SortLibrary {
    // methods are implemented with callback functions, i. e. with Comparable interface
    // this phenomenon is realized as follows:
    // Java: interfaces
    // C: function pointers
    // C++: class type functors
    // C#: delegates
    // Python, Perl, ML, Javascript: first-class functions

    // BASIC SORT ALGORITHMS
    public static void selectionSort(Comparable[] arr){
        for(int i = 0; i < arr.length; i++){
            int min = i;
            for(int j = i; j < arr.length; j++){
                if(less(arr[j],arr[min])) min = j;
            }
            swap(arr,i,min);
        }
    }

    public static void insertionSort(Comparable[] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = i; j > 0; j--){
               if(less(arr[j],arr[j-1]))
                   swap(arr, j, j-1);
               else break;
            }
        }
    }

    // invented in 1959
    // ex: 13-sort , 4-sort, finally 1-sort
    public static void shellSort(Comparable[] arr){
        //TODO re-write it for h series:  3*h - 1
        for(int i = 0; i < arr.length; i++){
            for(int j = i; j > 0; j -= 4){
                if(less(arr[j],arr[j-1]))
                    swap(arr, j, j-1);
                else break;
            }
        }

        for(int i = 0; i < arr.length; i++){
            for(int j = i; j > 0; j --){
                if(less(arr[j],arr[j-1]))
                    swap(arr, j, j-1);
                else break;
            }
        }
    }

    // proposed in 1938
    public static void shuffling(Comparable[] arr){
        Random rn = new Random();
        for(int i = 0; i < arr.length; i++){
            int rand = rn.nextInt() % i;
            swap(arr, i, rand);
        }
    }

    // ADVANCED SORT ALGORITHMS
    //John van Neumann, EDVAC computer,
    public static void mergeSort(Comparable[] arr){
        Comparable[] aux = arr.clone();
        sort(arr, aux, 0, arr.length - 1);
    }

    public static void sort(Comparable[] a, Comparable[] aux, int lo, int hi){
        int mid = (lo + hi) / 2;

        //TODO optimization: cut-off to get rid of overhead of merge sort for small arrays
        if(hi == lo) return;
        else if(hi - lo == 1){
            if(less(a[hi], a[lo])) swap(a, lo, hi);
        } else {
            sort(a, aux, lo, mid);
            sort(a, aux, mid + 1, hi);
            merge(a, aux, lo, mid + 1, hi);
        }
    }

    public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi){
        assert isSortedPart(a, lo, mid - 1);
        assert isSortedPart(a, mid, hi);

        aux = a.clone();
        int i = lo;
        int j = mid;

        for (int k = lo; k < hi + 1; k ++){
            if(i == mid){ a[k] = aux[j]; j++;}
            else if(j > hi){ a[k] = aux[i]; i++;}
            else if(less(aux[i],aux[j]) || aux[i] == aux[j]){ a[k] = aux[i]; i++;}
            else { a[k] = aux[j]; j++;}
        }
        assert isSortedPart(a, lo, hi);
    }

    //1961 Sir Charles Anthony Richard Hoare
    // be careful equal keys drive up the tcomplexity to quadratic time!
    // Soln: 3-way Dijkstra partitioning
    //TODO find the killer input for Java system sort! it sometimes crashes! ,
    // the reason is they didn't do shuffling
    public void quickSort(Comparable[] arr){
       // TODO
    }

    //A version of quick-sort, takes linear time on average! quadratic on worst case
    public void kthlargest(Comparable[] arr){
        // TODO
    }

    // Useful sorting abstractions
    public static boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }

    public static void swap(Comparable [] arr, int i, int j){
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static boolean isSorted(Comparable [] arr){
        for (int i = 1; i < arr.length; i++){
            if (less(arr[i], arr[i-1])) return false;
        }
        return true;
    }

    public static boolean isSortedPart(Comparable [] arr, int lo, int hi){ // check a partial section of array is sorted
        if(lo == hi) return true;
        else{
            for (int i = lo + 1; i < arr.length && i <= hi; i++){
                if (less(arr[i], arr[i-1])) return false;
            }
        }
        return true;
    }

    public static void printArray(Iterable arr){
        Iterator it = arr.iterator();
        while (it.hasNext()){
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }

    //flag problem
    /** Dutch national flag. Given an array of n buckets, each containing a red, white,
     * or blue pebble, sort them by color. The allowed operations are:
     *
     swap(i,j):  swap the pebble in bucket i with the pebble in bucket j.
     color(i): determine the color of the pebble in bucket i.

     The performance requirements are as follows:

     At most n calls to color().
     At most n calls to swap().
     Constant extra space.*/
    public static void threeWayPartitioning(Comparable [] arr){ // let's consider the elements are: r w b
        int i = 0;
        int j = 0;
        int n = arr.length - 1;

        while(j <= n && n >= j){
            if(arr[j] == "r"){
                swap(arr,j,i);
                i++;
                j++;
            } else if(arr[j] == "w"){
                j++;
            } else { // "b"
                swap(arr,j,n);
                n--;
            }
        }
    }
}
