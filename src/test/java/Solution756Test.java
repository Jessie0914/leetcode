import org.junit.Test;
import other.Solution756;

import java.util.ArrayList;
import java.util.List;

public class Solution756Test {

    @Test
    public void pyramidTransition() {
        Solution756 solution756 = new Solution756();
        List<String> allowed = new ArrayList<>();
        allowed.add("XXX");
        allowed.add("XXY");
        allowed.add("XYX");
        allowed.add("XYY");
        allowed.add("YXZ");
        boolean res = solution756.pyramidTransition("XXYX", allowed);
        System.out.println(res);
    }
}