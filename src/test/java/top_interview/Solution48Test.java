package top_interview;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution48Test {

    @Test
    public void rotate() {
        Solution48 solution48 = new Solution48();
        int[][] martrix = {{1,2,3},{4,5,6},{7,8,9}};
        solution48.rotate(martrix);
        for (int[] line : martrix){
            for (int i : line){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}