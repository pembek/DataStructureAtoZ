package misc_questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class FindIntersectionRectangle {
    public int[] maxSubsequenceOld(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> min = new PriorityQueue<>(k);

        for(int i = 0; i<n; i++){
            if(min.size() == k) {
                min.offer(nums[i]);
                min.poll();
            } else if (min.size() < k) {
                min.offer(nums[i]);
            } else {
                min.poll();
            }
        }
        ArrayList<Integer> l = new ArrayList(min);
        return l.stream().mapToInt(i -> i).toArray();
    }

    public static int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        int [] aux = nums.clone();
        int count = 0;

        ArrayList<Integer> l = new ArrayList();
        //find kth greatest element
        int ele = kthlargest(aux, n-k);
        for(int i = 0; i<n; i++){
            if(nums[i] >= ele){
                l.add(nums[i]);
                count++;
            }
            if(count >= k) break;
        }
        return l.stream().mapToInt(i -> i).toArray();
    }

    public static int kthlargest(int[] arr, int k){
        // TODO shuffle the array
        int lo = 0;
        int hi = arr.length - 1;
        while(lo < hi){
            int j = partition(arr, lo, hi);
            if(j < k){ // j is on the left
                lo = j + 1;
            }
            else if(j > k){ // j is on the right
                hi = j - 1;
            }
            else if(j == k) return arr[k];
        }
        return arr[k];
    }
    public static int partition(int[] a, int lo, int hi){
        int i = lo;
        int j = hi + 1;

        while(true){
            while(a[++i]<a[lo])
                if(i == hi) break;

            while(a[lo]<a[--j])
                if(j == lo) break;

            if(i >= j) break;
            swap(a, i, j);
        }
        swap(a, lo, j);
        return j;
    }
    public static void swap(int [] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    //                   l   h
    //Input: security = [5,3,3,3,5,6,2], time = 2
    //Output: [2,3]
    public List<Integer> goodDaysToRobBank(int[] s, int time) {
        int n = s.length;
        int lo = 0, hi = 0;
        List<Integer> l = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            if(hi - lo == time){
                if(s[i] <= s[i + 1]){
                    if(i - hi >= time) {
                        l.add(hi);
                    }
                } else if(s[i] > s[i + 1]){
                    lo = i;
                    hi = i;
                }
            }else {
                if(s[hi] >= s[hi + 1]){
                    hi++;
                    if(hi - lo > time)lo ++;
                }
                else {
                    hi++;
                    lo = hi;
                }
            }
        }
        return l;
    }
    // lets represent rectangles like {left, right, down, up} ~ {x1, x2, y1, y2}
    public static int [] getIntersection(int [] r1, int [] r2){
        int [] res = {0,0,0,0};
        int left1 = r1[0];
        int right1 = r1[1];
        int down1 = r1[2];
        int up1 = r1[3];
        int left2 = r2[0];
        int right2 = r2[1];
        int down2 = r2[2];
        int up2 = r2[3];

        // no intersection
        // left------------right
        //                          right-------------left

        // intersection exists
        // left------------right
        //          right-------------left
        if(Math.max(right2, right1) < Math.min(left2, left1) &&
           Math.max(down1, down2) < Math.min(up1, up2)) {
            // does not overlap
        } else {
            res[0] = Math.max(left2, left1); // intersection left
            res[1] = Math.min(right2, right1);  // intersection right
            res[2] = Math.max(down2, down1);  // intersection down/bottom
            res[3] = Math.min(up2, up1);  // intersection up
        }
        return res;
    }
}
