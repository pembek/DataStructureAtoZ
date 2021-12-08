package ds;

// Maximum oriented priority queue
public class PriorityQueueMin<T extends Comparable> {

    private T [] a;
    private int N;

    PriorityQueueMin(int capacity){
        a = (T[]) new Comparable[capacity];
        N = 0;
    }

    public void insert(T key){
        a[++N] = key;
        swim(N);
    }

    public T delMin(){
        if (isEmpty()) return null;

        T min = a[1];

        swap(a, 0, N);
        N--;

        sink(1);
        a[N+1] = null; // prevent loitering

        return min;
    }

    // Useful sorting abstractions
    public static boolean greater(Comparable a, Comparable b){
        return a.compareTo(b) > 0;
    }

    public static void swap(Comparable [] arr, int i, int j){
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void swim(int k){

        while(k > 1){

            if(greater(k/2,k) ){
                swap(a, k, k/2);
            }
            k = k/2;
        }
    }

    public void sink(int k){

        while(2*k <= N){
            int j = 2*k;

            if (j < N && greater(j, j+1)) j++; // find the smaller child

            if(!greater(k, j)) break;

            swap(a, k, j);
            k = j;
        }
    }

    public T min(){
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
