package misc_questions;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Comparator;

public class CourseScheduleIII {
    public static int scheduleCourse(int[][] courses) {
        int availDay = 0;
        Arrays.sort(courses,(a, b)->a[1]-b[1]); //Sort the courses by their deadlines
        PriorityQueue<Integer> pq = new PriorityQueue<>((p1, p2) -> p2 - p1); // max priority queue

        for(int [] c: courses){
            availDay += c[0];
            pq.offer(c[0]);

            if(availDay > c[1]) availDay -= pq.poll();
        }
        return pq.size();
    }
}
