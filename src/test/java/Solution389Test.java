import org.junit.Test;
import other.Solution389;

public class Solution389Test {

    @Test
    public void findTheDifference() {
        Solution389 solution389 = new Solution389();
        String s = "abcd";
        String t = "bdcae";
        char theDifference = solution389.findTheDifference(s, t);
        System.out.println(theDifference);
    }
}