package dynamic_programming;

import org.junit.Test;

import java.util.List;

public class Solution368Test {

    @Test
    public void largestDivisibleSubset() {
        Solution368 solution368 = new Solution368();
        int[] nums = {1,2,4,8};
        List<Integer> list = solution368.largestDivisibleSubset(nums);
        for (int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
    }
}