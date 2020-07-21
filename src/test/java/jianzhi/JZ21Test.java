package jianzhi;

import org.junit.Test;

import static org.junit.Assert.*;

public class JZ21Test {

    @Test
    public void isPopOrder() {
        JZ21 jz21 = new JZ21();
        int[] pushA = {1,2,3,4,5};
        int[] popA = {4,5,3,2,1};
        jz21.IsPopOrder(pushA,popA);
    }
}