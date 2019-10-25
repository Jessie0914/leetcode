package sort;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Solution386Test {

    @Test
    public void lexicalOrder() {
        Solution386 solution386 = new Solution386();
        List<Integer> list = solution386.lexicalOrder(13);
        for (int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
    }

    @Test
    public void lexicalOrder2() {
        Solution386 solution386 = new Solution386();
        List<Integer> list = solution386.lexicalOrder2(13);
        for (int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
    }
}