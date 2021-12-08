package ds;

// Named as ds.Deque_d because there's already a Java implementation
// which has the same name.
public interface Deque_d {

    public boolean isEmpty();

    // identical with the pop from ds.Stack_s
    public String dequeue();

    public void enqueue(String s);

}
