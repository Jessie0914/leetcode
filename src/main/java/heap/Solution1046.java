package heap;

/**
 * @ClassName Solution1046
 * @Description 1046.最后一块石头的重量
 * @Author shishi
 * @Date 2019/6/26 13:18
 **/

import java.util.Arrays;

/**
 * 也用了堆的思想，maxHeap
 * 这里学到了一个 优先队列内部其实不是排好序的，是按照地址排序的，你可以用iterator来测试
 * 但是你用peek()一个个取，还是按照顺序取出来的
 */
public class Solution1046 {
    public int lastStoneWeight(int[] stones) {
        // 如果数组本身只有一个数字，就直接返回即可
        if (stones.length==1){
            return stones[0];
        }

        // 将stones数组排好序，取最后两个数（最大的和第二大的），相减之后作为新的数据插入到stones数组中，并且大小-1
        // 经过这个循环之后，就只剩一个数据了
        while (stones.length>=2){
            Arrays.sort(stones);
            int max1 = stones[stones.length-1];
            int max2 = stones[stones.length-2];
            int minus = max1-max2;
            stones[stones.length-2] = minus;
            stones = Arrays.copyOfRange(stones, 0, stones.length - 1);
        }

        return stones[0];
    }
}
