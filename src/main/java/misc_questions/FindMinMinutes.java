package misc_questions;

import java.util.List;

// {11:00, 15:55, 12:11} given an hour array you should return minimum difference of two hours in minutes
// Time complexity  : O(n) solution
// Space complexity : constant, array of length 1440
public class FindMinMinutes {
    public static int getMinutes(List<String> list){
        int res = Integer.MAX_VALUE;
        int [] a = new int[1440];
        int first = 0, prev = 0;

        for(int i = 0; i < a.length; i++)
            a[i] = 0;

        for(int i = 0; i < list.size(); i++){
            String s = list.get(i);
            int val = Integer.valueOf(s.substring(0, s.indexOf(':'))) * 60 + Integer.valueOf(s.substring(s.indexOf(':')+1));
            a[val] += 1;
        }

        for(int i = 0; i < a.length; i++){
            if(a[i] > 1){
                return 0;
            } else if (a[i] > 0 && prev == 0 && first == 0){
                prev = i;
                first = i;
            } else if (a[i] > 0 && prev != 0){
                res = Math.min(res, i - prev);
            }
        }
        return res;
    }
}
