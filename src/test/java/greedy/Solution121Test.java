package greedy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution121Test {

    @Test
    public void maxProfit() {
        Solution121 solution121 = new Solution121();
        int[] prices = {5,3,7,10,2,11};
        int profit = solution121.maxProfit(prices);
        System.out.println(profit);
    }
}