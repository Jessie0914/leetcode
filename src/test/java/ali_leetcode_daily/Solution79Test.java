package ali_leetcode_daily;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution79Test {

    @Test
    public void exist() {
        Solution79 solution79 = new Solution79();
        char[][] board =
                {
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}
                };
        String word = "ABCCED";

        System.out.println(solution79.exist(board,word));
    }
}