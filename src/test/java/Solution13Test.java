import org.junit.Test;
import other.Solution13;

public class Solution13Test {

    @Test
    public void romanToInt() {
        Solution13 solution13 = new Solution13();
        int toInt = solution13.romanToInt("MCMXCIV");
        System.out.println(toInt);
    }
}