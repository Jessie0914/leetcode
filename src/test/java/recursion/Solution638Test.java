package recursion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class Solution638Test {

    @Test
    public void shoppingOffers() {
        Solution638 solution638 = new Solution638();
        List<Integer> price = new ArrayList<>();
        price.add(2);
        price.add(5);

        List<List<Integer>> special = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(3);
        l1.add(0);
        l1.add(5);
        special.add(l1);

        List<Integer> l2 = new ArrayList<>();
        l2.add(1);
        l2.add(2);
        l2.add(10);
        special.add(l2);

        List<Integer> needs = new ArrayList<>();
        needs.add(3);
        needs.add(2);

        int res = solution638.shoppingOffers(price, special, needs);
        System.out.println(res);
    }
}