package sort.bucketsort;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution41Test {

    @Test
    public void firstMissingPositive() {
        Solution41 solution41 = new Solution41();
        int[] nums = {1,2,3,10,2147483647,9};
        int i = solution41.firstMissingPositive(nums);
        System.out.println(i);
    }
}