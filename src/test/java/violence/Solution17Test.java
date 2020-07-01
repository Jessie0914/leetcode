package violence;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Solution17Test {

    @Test
    public void letterCombinations() {
        Solution17 solution17 = new Solution17();
        String digits = "23";
        List<String> strings = solution17.letterCombinations(digits);
        for (String s : strings){
            System.out.println(s);
        }
    }
}