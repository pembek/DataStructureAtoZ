// Maximum oriented priority queue
public class PriorityQueueMax<T extends Comparable> {

    private T [] a;
    private int N;

    PriorityQueueMax(int capacity){
        a = (T[]) new Comparable[capacity];
        N = 0;
    }

    public void insert(T key){
        a[++N] = key;
        swim(N);
    }

    public T delMax(){
        if (isEmpty()) return null;

        T max = a[1];

        swap(a, 0, N);
        N--;

        sink(1);
        a[N+1] = null; // prevent loitering

        return max;
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

    public void swim(int k){

        while(k > 1){

            if(less(k/2,k) ){
                swap(a, k, k/2);
            }
            k = k/2;
        }
    }

    public void sink(int k){

        while(2*k <= N){
            int j = 2*k;

            if (j < N && less(j, j+1)) j++; // find the larger child

            if(!less(k, j)) break;

            swap(a, k, j);
            k = j;
        }
    }

    public T max(){
        return a[1];
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    public void clear(){
        a = (T[]) new Comparable[100];
        N = 0;
    }
}
