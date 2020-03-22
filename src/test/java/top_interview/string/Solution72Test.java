package top_interview.string;

import org.junit.Test;

public class Solution72Test {

    @Test
    public void minDistance() {
        Solution72 solution72 = new Solution72();
        String word1 = "";
        String word2 = "ros";
        int i = solution72.minDistance(word1, word2);
        System.out.println(i);
    }
}