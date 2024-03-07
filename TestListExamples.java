import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;

public class TestListExamples {
    
    List<String> input1 = new ArrayList<>();
    List<String> input2 = new ArrayList<>();

    @Before
    public void setUp() {
        input1.clear();
        input1.add("apple");
        input1.add("banana");
        input1.add("pineapple");
        input2.clear();
        input2.add("cat");
        input2.add("dog");
        input2.add("rat");
    }

    @Test
    public void testFilter() {
        List<String> expected = new ArrayList<>();
        expected.add("apple");
        expected.add("pineapple");
        StringChecker containsAP = s -> s.contains("ap");
        assertArrayEquals(expected.toArray(), (ListExamples.filter(input1, containsAP)).toArray());
    }

    @Test
    public void testMerge() {
        List<String> expected = new ArrayList<>();
        expected.add("apple");
        expected.add("banana");
        expected.add("cat");
        expected.add("dog");
        expected.add("pineapple");
        expected.add("rat");
        assertArrayEquals(expected.toArray(), (ListExamples.merge(input1, input2)).toArray());
    }
}