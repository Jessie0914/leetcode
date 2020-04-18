package DayPractice.April;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution542Test {

    @Test
    public void updateMatrix() {
        Solution542 solution542 = new Solution542();
        int[][] matrix = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] ans = solution542.updateMatrix(matrix);
        for (int[] a : ans){
            for (int x:a){
                System.out.print(x+" ");
            }
            System.out.println();
        }
    }
}