package sort;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution242Test {

    @Test
    public void testIsAnagram() {
        Solution242 solution242 = new Solution242();
        boolean anagram = solution242.isAnagram("rat", "car");
        System.out.println(anagram);
    }
}