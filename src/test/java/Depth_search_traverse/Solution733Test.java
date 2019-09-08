package Depth_search_traverse;

import org.junit.Test;

public class Solution733Test {

    @Test
    public void floodFill() {
        Solution733 solution733 = new Solution733();
        int[][] image = {{0,0,1},{0,1,1}};
        int[][] result = solution733.floodFill(image, 1, 1, 1);
        for(int[] r : result){
            for (int i : r){
                System.out.print(i+" ");
            }
            System.out.println("----------------");
        }
    }
}