package tree.searchtree;

import org.junit.Test;

public class Solution96Test {

    @Test
    public void numTrees() {
        Solution96 solution96 = new Solution96();
        int numTrees = solution96.numTrees(14);
        System.out.println(numTrees);
    }

    @Test
    public void numTrees2() {
        Solution96 solution96 = new Solution96();
        System.out.println(solution96.numTrees2(4));
    }
}