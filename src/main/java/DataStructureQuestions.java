import java.util.HashMap;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class DataStructureQuestions {

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
}
