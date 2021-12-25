import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class SortQuestions{

    public static int[] twoSum(int[] nums, int target) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (Integer integer: nums){
            arrayList.add(integer);
        }
        ArrayList<Integer> sortedList = new ArrayList<>();
        sortedList.addAll(arrayList);
        Collections.sort(sortedList);
        for (int i = 0; i < sortedList.size(); i++){
            nums[i] = sortedList.get(i);
        }

        int[] res = new int[2];
        int index2 = -1, index1 = -1;
        for(int i = 0; i < nums.length; i++){
            index2 = binarySearchRecur(target - nums[i], nums, 0, nums.length);
            if(index2 != -1) {
                index1 = i;
                break;
            }
        }
        res[0] = arrayList.indexOf(sortedList.get(index1));
        res[1] = arrayList.indexOf(sortedList.get(index2));
        return (res);
    }

    public static int binarySearchRecur(int val, int[] arr, int lo, int hi){
        int medium = (hi + lo) / 2;

        if(lo > hi) {
            return -1;
        }

        if(arr[medium] == val)
            return medium;
        else if(val > arr[medium]){
            return binarySearchRecur(val, arr, medium, hi);
        }else{
            return binarySearchRecur(val, arr, lo, medium);
        }
    }

    public static double cube(int n){
        return n * n * n;
    }

    public static void convexHull() {
        //TODO
    }

    public static int minDifference(int[] nums) {
        mergeSort(nums);

        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int temp;
        for(int k = 0; k < 4; k++){
            temp = Math.abs(nums[len - 4 + k] - nums[k]);
            if(min > temp) min = temp;
        }

        return min;
    }

    public static void mergeSort(int[] a){
        int[] aux = new int[a.length];
        mergeSortRec(aux, a, 0, a.length-1);
    }

    public static void mergeSortRec(int[] aux, int[] a, int lo, int hi){
        int mid = (hi + lo) / 2;

        if(lo == hi) return;
        else if (hi - lo == 1){
            if (a[hi] < a[lo]){
                int temp = a[hi];
                a[hi] = a[lo];
                a[lo] = temp;
            }
        }else {
            mergeSortRec(aux, a, lo, mid);
            mergeSortRec(aux, a, mid + 1, hi);
            merge(aux, a, lo, mid + 1, hi);
        }
    }

    public static void merge(int[] aux, int[] a, int lo, int mid, int hi){
        for(int j = 0; j < a.length; j++){
            aux[j] = a[j];
        }
        int i = lo;
        int j = mid;

        for (int k = lo; k < hi + 1; k ++){
            if(i == mid){
                a[k] = aux[j];j++;
            }
            else if(j > hi){
                a[k] = aux[i]; i++;
            }
            else if(aux[i] <= aux[j]){
                a[k] = aux[i]; i++;
            }
            else{
                a[k] = aux[j]; j++;
            }
        }
    }
    public static int minDifference3(int[] nums){
        if (nums.length < 5) return 0;
        if (nums.length <= 8) return getDiff(nums, true);
        PriorityQueue<Integer> top4 = new PriorityQueue<>(); // default is min
        PriorityQueue<Integer> bot4 = new PriorityQueue<>((a, b) -> b - a); // max priority queue
        PriorityQueue<Integer[]> botdene = new PriorityQueue<>
                ((o1, o2) -> (o2[1] - o2[0])-(o1[1] - o1[0])); // min priority queue


        for (int n : nums) {
            top4.offer(n);
            bot4.offer(n);
            if (top4.size() > 4) top4.poll();
            if (bot4.size() > 4) bot4.poll();
        }
        int[] arr = new int[8];
        for (int l = 3, r = 4; l >= 0 && r < 8; l--, r++) {
            arr[l] = bot4.poll();
            arr[r] = top4.poll();
        }
        return getDiff(arr, false);
    }
    public static int getDiff(int[] nums, boolean sort){
        if (sort) Arrays.sort(nums);
        int res = Integer.MAX_VALUE, n = nums.length;
        for (int i = 0; i < 4; i++) {
            res = Math.min(res, nums[n - (4 - i)] - nums[i]);
        }
        return res;
    }

    public static int minDifference2(int[] nums) {
        if(nums.length < 5) return 0;

        //quickSort(nums);
        List<Integer> list = new ArrayList<>();

        for(int k = 0; k < 4; k++)
            list.add(kthlargest(nums, 3 - k));
        for(int k = 0; k < 4; k++)
            list.add(kthlargest(nums, nums.length-k-1));

        int min = Integer.MAX_VALUE;
        int temp;
        for(int k = 0; k < 4; k++){
            temp = Math.abs(list.get(list.size() - 4 + k) - list.get(k));
            if(min > temp) min = temp;
        }

        return min;
    }

    // A version of quick-sort, takes linear time on average! quadratic on worst case
    // 1961 Hoare
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

    public static void quickSort(int[] arr){
        // we assume the array is shuffled
        quickSortRecursive(arr, 0 , arr.length-1);
    }

    public static void quickSortRecursive(int[] a, int lo, int hi){
        if(lo >= hi) return;
        int j = partition(a, lo, hi);
        quickSortRecursive(a, lo, j-1);
        quickSortRecursive(a, j+1, hi);
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

    public static int countPairs2(int[] deliciousness) {
        int n = deliciousness.length*(deliciousness.length-1) / 2;
        int[] totals = new int[n];
        int meals = 0;

        int z = 0;
        for(int i = 0; i < deliciousness.length; i++)
            for(int j = i + 1; j < deliciousness.length; j++)
                totals[z++] = deliciousness[i] + deliciousness[j];

        for(int i = 0; i < n; i++){
            for(int k = 0; k < 21; k++){
                if(totals[i] == Math.pow(2,k)) meals++;
            }
        }
        return meals;
    }

    public static int countPairs(int[] deliciousness) {
        long meals = 0;
        int power = 1;

        HashMap<Integer,Integer> ht = new HashMap<>();

        for(int i = 0; i < deliciousness.length; i++){
            power = 1;
            for(int k = 0; k < 22; k++){
                if(ht.containsValue(power - deliciousness[i])){
                    meals += ht.get(power - deliciousness[i]);
                    //meals = meals % 1000000007;
                }
                power *= 2;
            }
            ht.put(deliciousness[i], ht.getOrDefault(deliciousness[i],0) + 1);
        }
        return (int) meals;
    }

    public static int binarySearch(int[] a, int lo, int hi, int key) {
        int mid = (hi + lo) / 2;

        if(lo > hi) return -1;

        if(key == a[mid]){
            return mid;
        }else if(key < a[mid]){
            return binarySearch(a, lo, mid-1, key);
        }else if(key > a[mid]){
            return binarySearch(a, mid+1, hi, key);
        }
        return -1;
    }

}
