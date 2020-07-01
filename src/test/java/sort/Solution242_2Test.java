package sort;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution242_2Test {

    @Test
    public void isAnagram() {
        Solution242_2 solution242_2 = new Solution242_2();
        boolean anagram = solution242_2.isAnagram("abcde", "abdec");
        System.out.println(anagram);
    }
}