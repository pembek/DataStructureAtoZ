import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PriorityQueueMaxTest {
    private static PriorityQueueMax priorityQueueMax;

    @BeforeClass
    public static void instantiate(){
        priorityQueueMax = new PriorityQueueMax(100);
    }

    @Before
    public void cleanQueue(){
        priorityQueueMax.clear();
    }

    @Test
    public void basicCaseShouldBeTrue() {

    }
}
