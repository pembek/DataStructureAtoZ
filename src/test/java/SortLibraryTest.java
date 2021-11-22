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
    public void mergeSortTest(){
        array = new String[]{"ogs", "abc", "fat", "cat",
                "tot", "gut", "but", "ogs", "bob", "zat",
                "kik", "sek"};
        SortLibrary.printArray(new ArrayList<String>(Arrays.asList(array)));
        SortLibrary.mergeSort(array);
        SortLibrary.printArray(new ArrayList<String>(Arrays.asList(array)));
        assertTrue(SortLibrary.isSorted(array));
    }
}
