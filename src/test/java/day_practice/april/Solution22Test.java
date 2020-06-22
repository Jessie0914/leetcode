package day_practice.april;

import org.junit.Test;

import java.util.List;

public class Solution22Test {

    @Test
    public void generateParenthesis() {
        Solution22 solution22 = new Solution22();
        List<String> list = solution22.generateParenthesis(3);
        for (String s : list)
            System.out.println(s);
    }
}