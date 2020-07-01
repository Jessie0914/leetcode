package bitmanipulation;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution136Test {
    public static void main(String[] args) {
        System.out.println(1^3);
    }

    Solution136 solution136;
    @Test
    public void singleNumber() {
        this.solution136 = new Solution136();
        int[] nums = {4,1,2,2,1};
        int result = solution136.singleNumber(nums);
        System.out.println(result);
    }

    @Test
    public void singleNumber2() {
        this.solution136 = new Solution136();
        int[] nums = {1,2,2,1,4};
        int result = solution136.singleNumber2(nums);
        System.out.println(result);
    }
}