import org.junit.Test;

public class Solution605Test {

    @Test
    public void canPlaceFlowers() {
        Solution605 solution605 = new Solution605();
        int[] flowered = {1,0,0,0,0,1};
        int n = 2;
        boolean b = solution605.canPlaceFlowers(flowered, n);
        System.out.println(b);
    }
}