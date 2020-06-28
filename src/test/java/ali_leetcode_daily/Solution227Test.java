package ali_leetcode_daily;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution227Test {

    @Test
    public void calculate() {
        Solution227 solution227 = new Solution227();
        String s = "1+1+2*2";
        int calculate = solution227.calculate(s);
        System.out.println(calculate);
    }

    @Test
    public void test(){
        String s = "    5/  2";
        s = s.replaceAll(" ","");
        System.out.println(s);
    }
}