public class DequeWithLinkedList implements Deque_d{
    public class Node{
        String val;
        Node next;
    }
    Node first;
    Node last;

    @Override
    public boolean isEmpty() {
        return (first == null);
    }

    @Override
    public String dequeue() {
        if(isEmpty())
            return null;
        String s = first.val;
        first = first.next;
        if(isEmpty()) last = null;
        return s;
    }

    @Override
    public void enqueue(String s) {
        Node oldLast = last;

        last = new Node();
        last.val = s;
        last.next = null;

        if(isEmpty()){
            first = last;
        } else{
            oldLast.next = last;
        }
    }
}
