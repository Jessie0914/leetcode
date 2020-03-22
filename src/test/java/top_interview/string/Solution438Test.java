package top_interview.string;

import org.junit.Test;

import java.util.List;

public class Solution438Test {

    @Test
    public void findAnagrams() {
        Solution438 solution438 = new Solution438();
        List<Integer> anagrams = solution438.findAnagrams("acdcaeccde","c");
        for (int i : anagrams){
            System.out.println(i);
        }
    }
}