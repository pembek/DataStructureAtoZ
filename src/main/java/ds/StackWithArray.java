package ds;

import java.util.Deque;

public class StackWithArray implements Stack_s{

    String [] array;
    int head = 0;
    Deque<String> deque;

    public StackWithArray(){
        array = new String[10];
    }

    @Override
    public void push(String s) {
        if(head == array.length){
                resize(2 * array.length);
        }
        array[head++] = s;
    }

    //grow array with repeated doubling
    public void resize(int capacity){
        String [] newArray = new String[capacity];
        for (int i = 0; i < head; i++){
            newArray[i] = array[i];
        }
        array = newArray;
    }

    /** @Override
    public String pop() {
        //array[head] = null; // NOTE: LINE TO AVOID LOITERING
        //Loitering: Holding a reference to an object when it is no longer needed
        return array[--head];
    } */

    /** An alternate pop :
     * shrinks the array when it's quarter full */
    @Override
    public String pop() {
        String item = array[--head];
        array[head] = null; // NOTE: LINE TO AVOID LOITERING
        //Loitering: Holding a reference to an object when it is no longer needed
        if(head == array.length / 4){
            resize(array.length / 2);
        }
        return item;
    }

    @Override
    public boolean isEmpty() {
        return (head == 0);
    }

    @Override
    public int size() {
        return head;
    }
}
