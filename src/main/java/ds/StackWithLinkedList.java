package ds;

import java.util.ArrayList;

public class StackWithLinkedList implements Stack_s {
    public class Node{
        String val;
        Node next;
    }

    Node head;
    int size;

    ArrayList<String> arr;

    StackWithLinkedList(){
        head = null;
    }

    @Override
    public void push(String s) {
        if(isEmpty()){
            head = new Node();
            head.val = s;
        }else{
            Node newNode = new Node();
            newNode.val = s;
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    @Override
    public String pop() {
        String res = null;
        if(!isEmpty()){
            res = head.val;
            head = head.next;
            size--;
        }
        return res;
    }

    @Override
    public boolean isEmpty() {
        return (head == null);
    }

    @Override
    public int size() {
        return size;
    }
}
