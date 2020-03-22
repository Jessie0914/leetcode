import org.junit.Test;
import other.Solution861;

public class Solution861Test {

    @Test
    public void matrixScore() {
        Solution861 solution861 = new Solution861();
        int[][] A = {{0},{0},{1},{1}};
        int sum = solution861.matrixScore(A);
        System.out.println(sum);
    }
}