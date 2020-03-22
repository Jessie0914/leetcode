package search;

import org.junit.Test;

public class Solution704Test {

    @Test
    public void search() {
        Solution704 solution704 = new Solution704();
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        int search = solution704.search(nums, target);
        System.out.println(search);
    }
}