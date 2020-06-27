package ali_leetcode_daily;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution695Test {

    @Test
    public void maxAreaOfIsland() {
        Solution695 solution695 = new Solution695();
        int[][] grid = {
//                {0,0,1,0,0,0,0,1,0,0,0,0,0},
//                {0,0,0,0,0,0,0,1,1,1,0,0,0},
//                {0,1,1,0,1,0,0,0,0,0,0,0,0},
//                {0,1,0,0,1,1,0,0,1,0,1,0,0},
//                {0,1,0,0,1,1,0,0,1,1,1,0,0},
//                {0,0,0,0,0,0,0,0,0,0,1,0,0},
//                {0,0,0,0,0,0,0,1,1,1,0,0,0},
//                {0,0,0,0,0,0,0,1,1,0,0,0,0}

//                {0,0,0,1},
//                {0,0,0,1},
//                {0,0,0,1},
//                {1,1,1,1}

//                {0,0},
//                {1,1}

//                {1,1,1},
//                {1,0,0}

                {1,1,0,0,0},
                {1,1,0,0,0},
                {0,0,0,1,1},
                {0,0,0,1,1}
        };
        int maxAreaOfIsland = solution695.maxAreaOfIsland(grid);
        System.out.println(maxAreaOfIsland);
    }
}