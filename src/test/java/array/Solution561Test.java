package array;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution561Test {

    @Test
    public void arrayPairSum() {
        Solution561 solution561 = new Solution561();
        int[] nums = {1,2,3,4};
        int sum = solution561.arrayPairSum(nums);
        System.out.println(sum);
    }
}