package String;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution657Test {

    @Test
    public void judgeCircle() {
        Solution657 solution657 = new Solution657();
        String moves = "LL";
        boolean flag = solution657.judgeCircle(moves);
        System.out.println(flag);
    }
}