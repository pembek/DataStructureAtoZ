public class DequeG<T>{
    public class Node{
        T val;
        Node next;
    }
    Node first;
    Node last;

    public boolean isEmpty() {
        return (first == null);
    }

    public T dequeue() {
        if(isEmpty())
            return null;
        T val = first.val;
        first = first.next;
        if(isEmpty()) last = null;
        return val;
    }

    public void enqueue(T val) {
        Node oldLast = last;

        last = new Node();
        last.val = val;
        last.next = null;

        if(isEmpty()){
            first = last;
        } else{
            oldLast.next = last;
        }
    }
}
