package cyc.algorithm.dynamic_programming;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Number120Test {

    @Test
    public void minimumTotal() {
        Number120 number120 = new Number120();
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3,4));
        triangle.add(Arrays.asList(6,5,7));
        triangle.add(Arrays.asList(4,1,8,3));

        int i = number120.minimumTotal(triangle);
        System.out.println(i);
    }
}