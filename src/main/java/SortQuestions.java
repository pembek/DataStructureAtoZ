import java.util.ArrayList;
import java.util.Collections;

public class SortQuestions {
    public static void main(String args []){
        int [] myNums = {23,24,52,31,43,16,19,2,7,11,15};
        int target = 9;

        int [] expected = twoSum(myNums, target);

        System.out.println(expected[0] + " - " + expected[1]);

    }

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

    public static void convexHull() {
        //TODO
    }
}
