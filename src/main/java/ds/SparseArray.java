package ds;

import java.util.HashMap;

public class SparseArray{
    HashMap<Integer, Integer> mapNonZero;

    public SparseArray(){
        mapNonZero = new HashMap<>();
    }

    public void init(int [] arr, int size){
        int i = 0;

        while(i < arr.length){
            while(arr[i++] == 0);
            mapNonZero.put(i,arr[i]);
        }
    }

    public void set(int i, int val){
        if(val != 0){
            mapNonZero.put(i,val);
        }
    }

    public int get(int i){
        if(mapNonZero.containsValue(i)){
            return mapNonZero.get(i);
        }else{
            return 0;
        }
    }
}

