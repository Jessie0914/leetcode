package array;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution289Test {

    @Test
    public void gameOfLife() {
        Solution289 solution289 = new Solution289();
        int[][] borad = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        solution289.gameOfLife(borad);
        for (int i=0;i<borad.length;i++){
            for (int j=0;j<borad[0].length;j++){
                System.out.print(borad[i][j]+" ");
            }
            System.out.println();
        }
    }
}