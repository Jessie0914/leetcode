package jianzhi;

import org.junit.Test;

import static org.junit.Assert.*;

public class JZ6Test {

    @Test
    public void minNumberInRotateArray() {
        JZ6 jz6 = new JZ6();
        int[] array = {3,3,3};
        int i = jz6.minNumberInRotateArray(array);
        System.out.println(i);
    }
}