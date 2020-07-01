import org.junit.Test;
import other.Solution119;

import java.util.List;

public class Solution119Test {

    @Test
    public void getRow() {
        Solution119 solution119 = new Solution119();
        List<Integer> list = solution119.getRow(3);
        for (Integer i : list){
            System.out.print(i + " ");
        }
    }
}