package array;

import org.junit.Test;

public class Solution1144Test {

    @Test
    public void movesToMakeZigzag() {
        Solution1144 solution1144 = new Solution1144();
        int[] nums = {1,2,3,9,9,6,1};
        int moves = solution1144.movesToMakeZigzag(nums);
        System.out.println(moves);
    }
}