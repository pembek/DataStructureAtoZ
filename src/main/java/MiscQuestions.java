import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MiscQuestions {

    // Definition for Employee.
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;

        Employee(int id){
            this.id = id;
            importance = 0;
            subordinates = null;
        }
    };

    public static int maxScore(int[] c, int k) {
        int max = 0, len = c.length;
        int[] r = new int[len];
        int[] l = new int[len];

        r[0] = c[0];
        l[len-1] = c[len-1];

        for(int i = 1; i < k; i++) r[i] += r[i-1] + c[i];
        for(int i = len - 2; i > len - k - 1; i--) l[i] += l[i+1] + c[i];

        for(int j = 0; j < k-1; j++){
            max = Math.max(r[j] + l[len-k+j+1], max);
        }
        max = Math.max(Math.max(r[k-1],l[len-k]), max);
        return max;
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;

        // Sort by ascending starting point
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);
        for (int[] interval : intervals) {
            if (interval[0] <= newInterval[1]) // Overlapping intervals, move the end if needed
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            else {                             // Disjoint intervals, add the new interval to the list
                newInterval = interval;
                result.add(newInterval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}

