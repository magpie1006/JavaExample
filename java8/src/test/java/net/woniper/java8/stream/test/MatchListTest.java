package net.woniper.java8.stream.test;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by woniper on 2016. 12. 3..
 */
public class MatchListTest {

    private List<String> targetList = Arrays.asList("a", "b", "c", "d", "e");
    private List<String> filterList = Arrays.asList("a", "b");

    @Test
    public void testNonMatch() throws Exception {
        assertTrue(targetList.stream().noneMatch(Predicate.isEqual("f")));
        assertFalse(targetList.stream().noneMatch(Predicate.isEqual("a")));
    }

    @Test
    public void testAnyMatch() throws Exception {
        assertTrue(targetList.stream().anyMatch(Predicate.isEqual("a")));
        assertFalse(targetList.stream().anyMatch(Predicate.isEqual("f")));
    }

    @Test
    public void testAllMatch() throws Exception {
        assertFalse(targetList.stream().allMatch(Predicate.isEqual("a")));
        assertFalse(targetList.stream().allMatch(Predicate.isEqual("f")));
    }

    @Test
    public void testTwoListNonMatch() throws Exception {
        List<String> filteredList = targetList.stream()
                .filter(target -> filterList.stream().noneMatch(Predicate.isEqual(target)))
                .collect(Collectors.toList());

        System.out.println(filteredList);  // [c, d, e]
        assertTrue(filteredList.size() == 3);
    }

    @Test
    public void testTwoListAnyMatch() throws Exception {
        List<String> filteredList = targetList.stream()
                .filter(target -> filterList.stream().anyMatch(Predicate.isEqual(target)))
                .collect(Collectors.toList());

        System.out.println(filteredList);   // [a, b]
        assertTrue(filteredList.size() == 2);
    }

    @Test
    public void testTwoListAllMatch() throws Exception {
        List<String> filteredList = targetList.stream()
                .filter(target -> filterList.stream().allMatch(Predicate.isEqual(target)))
                .collect(Collectors.toList());

        System.out.println(filteredList);   // []
        assertTrue(filteredList.size() == 0);
    }

    @Test
    public void allMatch() throws Exception {
        List<Integer> targetList = Arrays.asList(1, 2, 3, 4, 5);
        assertTrue(targetList.stream().allMatch(n -> n < 6));
        assertFalse(targetList.stream().allMatch(n -> n > 6));
    }
}
