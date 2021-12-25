package misc_questions;

import java.util.ArrayDeque;
import java.util.Deque;

public class DecodeString {
    public static String decodeString(String s) {
        Deque<Integer> op = new ArrayDeque<>();
        Deque<String> str = new ArrayDeque<>();
        int dgt = 0;
        String temp = "";

        for(char c: s.toCharArray()){
            if( Character.isDigit(c) ) {
                if(!temp.equals("")) {
                    str.push(temp);
                    temp = "";
                }
                dgt = Character.getNumericValue(c) + 10 * dgt;
            } else if( c == '[' ) {
                str.push("[");
                op.push(dgt);
                dgt = 0;
            } else if( Character.isLetter(c) ){
                temp = temp + c;
            } else if( c == ']' ) {
                if(temp.equals("")) {
                    while(!str.peek().equals("["))
                        temp = str.pop() + temp;
                }
                while(!str.peek().equals("[")) temp = str.pop() + temp;
                str.pop();
                int d = op.pop();
                String st = "";
                for(int i = 0; i < d ; i++) st = st + temp;
                str.push(st);
                temp = "";
            }
        }
        str.push(temp);

        String ans = "";
        while(!str.isEmpty()) {
            if(!str.peek().equals("[")) ans = str.pop() + ans;
            else str.pop();
        }
        return ans;
    }
}
