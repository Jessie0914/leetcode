package String;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Solution1002Test {

    @Test
    public void commonChars() {
        Solution1002 solution1002 = new Solution1002();
        String[] A = {"cool","lock","cook"};
        List<String> strings = solution1002.commonChars2(A);
        for (int i=0;i<strings.size();i++){
            System.out.println(strings.get(i));
        }
    }
}