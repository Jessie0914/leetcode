package ali_leetcode_daily.bytedance;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution121Test {

    @Test
    public void maxProfit2() {
        Solution121 solution121 = new Solution121();
        int[] prices = {7,1,5,3,6,4};
        int i = solution121.maxProfit2(prices);
        System.out.println(i);
    }
}