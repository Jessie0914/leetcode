import org.junit.Test;
import other.Solution118;

import java.util.List;

public class Solution118Test {

    @Test
    public void generate() {
        Solution118 solution118 = new Solution118();
        List<List<Integer>> result = solution118.generate(3);
        for (List list : result){
            for (Object i : list){
                System.out.print(i+" ");
            }
            System.out.println("---------");
        }
    }
}