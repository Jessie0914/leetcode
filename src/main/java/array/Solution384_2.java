package array;

import java.util.Random;

/**
 * @ClassName Solution384_2
 * @Description TODO
 * @Author shishi
 * @Date 2019/10/14 16:12
 **/
public class Solution384_2 {
    private int[] array;
    private int[] original;

    private Random random = new Random();

    public Solution384_2(int[] nums) {
        array = nums;
        original = nums.clone();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        array = original;
        original = original.clone();
        return array;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int i=0;i<array.length;i++){
            int j;
            j = i+random.nextInt(array.length-i);
            swap(array,i,j);
        }
        return array;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
