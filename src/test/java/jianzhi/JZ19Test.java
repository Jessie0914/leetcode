package jianzhi;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class JZ19Test {

    @Test
    public void printMatrix() {
        JZ19 jz19 = new JZ19();
        int[][] matrix = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15}};
        ArrayList<Integer> list = jz19.printMatrix(matrix);
        System.out.println(list.toArray().toString());
    }
}