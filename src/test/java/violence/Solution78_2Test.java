package violence;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Solution78_2Test {

    @Test
    public void subsets() {
        Solution78_2 solution78_2 = new Solution78_2();
        int[] nums={1,2,3};
        List<List<Integer>> subsets = solution78_2.subsets(nums);
    }
}