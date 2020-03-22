import org.junit.Test;
import other.Solution744;

public class Solution744Test {

    @Test
    public void nextGreatestLetter() {
        Solution744 solution744 = new Solution744();
        char[] letters = {'c', 'f', 'j'};
        char target = 'a';
        char c = solution744.nextGreatestLetter(letters, target);
        System.out.println(c);
    }
}