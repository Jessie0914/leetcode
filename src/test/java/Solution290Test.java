import org.junit.Test;
import other.Solution290;

public class Solution290Test {

    @Test
    public void wordPattern() {
        Solution290 solution290 = new Solution290();
        boolean b = solution290.wordPattern("jquery", "jquery");
        System.out.println(b);
    }
}