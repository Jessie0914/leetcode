import org.junit.Test;
import other.Solution400;

public class Solution400Test {

    @Test
    public void findNthDigit() {
        Solution400 solution400 = new Solution400();
        int nthDigit = solution400.findNthDigit(15);
        System.out.println(nthDigit);
    }

    @Test
    public void findNthDigit2() {
        Solution400 solution400 = new Solution400();
        int nthDigit = solution400.findNthDigit2(1000000000);
        System.out.println(nthDigit);
    }
}