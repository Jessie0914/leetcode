package top_interview;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Solution54Test {

    @Test
    public void spiralOrder() {
        Solution54 solution54 = new Solution54();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> list = solution54.spiralOrder(matrix);
        for (int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
    }
}