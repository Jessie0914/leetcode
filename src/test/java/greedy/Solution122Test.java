package greedy;

import org.junit.Test;


public class Solution122Test {

    @Test
    public void maxProfit() {
        Solution122 solution122 = new Solution122();
        int[] prices = {1,2,3,4,5};
        int maxProfit = solution122.maxProfit(prices);
        System.out.println(maxProfit);
    }
}