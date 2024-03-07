import static org.junit.Assert.*;
import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class IsMoon implements StringChecker {
  public boolean checkString(String s) {
    return s.equalsIgnoreCase("moon");
  }
}

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

  @Test(timeout = 500)
  public void testMergeRightEnd() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("a", "d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals(expected, merged);
  }
}
