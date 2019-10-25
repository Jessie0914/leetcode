package array;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution645Test {

    @Test
    public void findErrorNums() {
        Solution645 solution645 = new Solution645();
        int[] nums = {3,2,2};
        int[] errorNums = solution645.findErrorNums(nums);
        System.out.println(errorNums[0]+" "+errorNums[1]);
    }
}