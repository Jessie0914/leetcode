package day_practice.april;

import org.junit.Test;

public class Solution33Test {

    @Test
    public void search() {
        Solution33 solution33 = new Solution33();
        int[] nums = {4,5,6,7,0,1,2};
        int search = solution33.search(nums, 6);
        System.out.println(search);
    }
}