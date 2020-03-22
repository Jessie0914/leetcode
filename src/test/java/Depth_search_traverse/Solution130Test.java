package Depth_search_traverse;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution130Test {

    @Test
    public void solve() {
        Solution130 solution130 = new Solution130();
        char[][] board = {{'X', 'X', 'X', 'X'},{'X', 'O', 'O', 'X'},{'X', 'O', 'O', 'X'},{'X', 'O', 'X', 'X'}};
        solution130.solve(board);
        for (char[] line : board){
            for (char c:line){
                System.out.print(c+" ");
            }
            System.out.println();
        }
    }
}