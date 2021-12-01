import org.junit.Before;
import org.junit.Test;
import org.junit.BeforeClass;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;


public class SortLibraryTest {
    //private static SortLibrary sortLibrary;
    private static String [] array = new String[10];
    private static Double [] arrayD;

    @BeforeClass
    public static void instantiate(){

    }

    @Before
    public void cleanArray(){
        array = new String[]{""};
    }

    @Test
    public void sortSelectionTest(){
        array = new String[]{"bob", "cat", "fat", "abc",
                "tot", "gut", "but", "oğş", "zat",
                "kik", "sek"};
        SortLibrary.printArray(new ArrayList<String>(Arrays.asList(array)));
        SortLibrary.selectionSort(array);
        SortLibrary.printArray(new ArrayList<String>(Arrays.asList(array)));
        assertTrue(SortLibrary.isSorted(array));
    }

    @Test
    public void sortInsertionTest(){
        array = new String[]{"bob", "cat", "fat", "abc",
                "tot", "gut", "but", "oğş", "zat",
                "kik", "sek"};
        SortLibrary.printArray(new ArrayList<String>(Arrays.asList(array)));
        SortLibrary.insertionSort(array);
        SortLibrary.printArray(new ArrayList<String>(Arrays.asList(array)));
        assertTrue(SortLibrary.isSorted(array));
    }

    @Test
    public void shellSortTest(){
        array = new String[]{"bob", "cat", "fat", "abc",
                "tot", "gut", "but", "oğş", "zat",
                "kik", "sek"};
        SortLibrary.printArray(new ArrayList<String>(Arrays.asList(array)));
        SortLibrary.shellSort(array);
        SortLibrary.printArray(new ArrayList<String>(Arrays.asList(array)));
        assertTrue(SortLibrary.isSorted(array));
    }

    @Test
    public void shufflingTest(){
        array = new String[]{"bob", "cat", "fat", "abc",
                "tot", "gut", "but", "oğş", "zat",
                "kik", "sek"};
        SortLibrary.printArray(new ArrayList<String>(Arrays.asList(array)));
        SortLibrary.shellSort(array);
        SortLibrary.printArray(new ArrayList<String>(Arrays.asList(array)));
        assertTrue(SortLibrary.isSorted(array));
    }

    @Test
    public void threeWayPartitioningTest(){
        array = new String[]{"b", "r", "w", "w",
                "w", "r", "b", "b", "w",
                "w", "r"};
        SortLibrary.printArray(new ArrayList<String>(Arrays.asList(array)));
        SortLibrary.threeWayPartitioning(array);
        SortLibrary.printArray(new ArrayList<String>(Arrays.asList(array)));
        assertTrue(SortLibrary.isSorted(array));
    }

    @Test
    public void mergeSortTestStrings(){
        array = new String[]{"ogs", "abc", "fat", "cat",
                "tot", "gut", "but", "ogs", "bob", "zat",
                "kik", "sek"};
        SortLibrary.printArray(new ArrayList<String>(Arrays.asList(array)));
        SortLibrary.mergeSort(array);
        SortLibrary.printArray(new ArrayList<String>(Arrays.asList(array)));
        assertTrue(SortLibrary.isSorted(array));
    }

    @Test
    public void mergeSortTestDouble(){
        arrayD = new Double[]{1.0, 54.0, 555.0, 3.0,
                5.0, 778.0, 122.0, 24.0, 455.0, 99.0,
                88.0, 77.0,33.0};
        SortLibrary.printArray(new ArrayList<>(Arrays.asList(arrayD)));
        SortLibrary.mergeSort(arrayD);
        SortLibrary.printArray(new ArrayList<>(Arrays.asList(arrayD)));
        assertTrue(SortLibrary.isSorted(arrayD));
    }

    @Test
    public void partitionTest(){
        array = new String[]{"K", "R", "A", "T",
                "E", "L", "E", "P", "U", "I","M","Q","C","X",
                "O", "S"};
        SortLibrary.printArray(Arrays.asList(array));
        int partition = SortLibrary.partition(array,0,array.length-1);

        assertEquals(5, partition);
    }

    @Test
    public void quickSortTest(){
        array = new String[]{"K", "R", "A", "T",
                "E", "L", "E", "P", "U", "I","M","Q","C","X",
                "O", "S"};
        SortLibrary.printArray(Arrays.asList(array));
        SortLibrary.quickSort(array);
        SortLibrary.printArray(Arrays.asList(array));
    }

    @Test
    public void kthLargestTest(){
        array = new String[]{"K", "R", "A", "T",
                "E", "L", "E", "P", "U", "I","M","Q","C","X",
                "O", "S"};
        SortLibrary.printArray(Arrays.asList(array));

        assertEquals("A", SortLibrary.kthlargest(array, 15));
    }
}
