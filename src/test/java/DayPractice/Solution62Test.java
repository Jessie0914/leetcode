package DayPractice;

import DayPractice.March.Solution62;
import org.junit.Test;

public class Solution62Test {

    @Test
    public void lastRemaining() {
        Solution62 solution62 = new Solution62();
        int i = solution62.lastRemaining(10, 17);
        System.out.println(i);
    }
}