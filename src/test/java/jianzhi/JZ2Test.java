package jianzhi;

import org.junit.Test;

import static org.junit.Assert.*;

public class JZ2Test {

    @Test
    public void replaceSpace() {
        JZ2 jz2 = new JZ2();
        StringBuffer str = new StringBuffer("We are happy");
        String s = jz2.replaceSpace(str);
        System.out.println(s);
    }
}