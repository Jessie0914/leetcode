package heap;

import org.junit.Test;

import java.awt.font.NumericShaper;

import static org.junit.Assert.*;

public class Solution703Test {

    @Test
    public void testAdd() {
        int[] nums = {4,5,8,2};
        Solution703_2 solution703_2 = new Solution703_2(3, nums);
        System.out.println(solution703_2.add(3));
        System.out.println(solution703_2.add(5));
        System.out.println(solution703_2.add(10));
        System.out.println(solution703_2.add(9));
        System.out.println(solution703_2.add(4));
    }
}