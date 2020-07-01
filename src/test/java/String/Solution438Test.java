package String;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Solution438Test {

    @Test
    public void findAnagrams() {
        Solution438 solution438 = new Solution438();
        List<Integer> anagrams = solution438.findAnagrams("baa", "aa");
        for (int i : anagrams){
            System.out.println(i);
        }
    }
}