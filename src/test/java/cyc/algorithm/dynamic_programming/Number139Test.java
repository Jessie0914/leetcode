package cyc.algorithm.dynamic_programming;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class Number139Test {

    @Test
    public void wordBreak() {
        Number139 number139 = new Number139();
        String s = "catsandog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("dog");
        boolean wordBreak = number139.wordBreak(s, wordDict);
        System.out.println(wordBreak);
    }
}