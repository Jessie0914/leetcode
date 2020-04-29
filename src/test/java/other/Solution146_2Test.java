package other;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution146_2Test {

    @Test
    public void get() {
        Solution146 solution146 = new Solution146(1);
        solution146.put(2,1);
        System.out.println(solution146.get(2));
        solution146.put(3,2);
        System.out.println(solution146.get(2));
        System.out.println(solution146.get(3));
    }
}