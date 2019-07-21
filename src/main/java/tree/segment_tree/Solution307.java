package tree.segment_tree;

/**
 * @ClassName Solution307
 * @Description 307.区域和检索-数组可修改
 * @Author shishi
 * @Date 2019/7/13 13:11
 **/

/**
 * 给定一个整数数组 nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 * update(i, val) 函数可以通过将下标为 i 的数值更新为 val，从而对数列进行修
 *
 * 示例：
 * Given nums = [1, 3, 5]
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 */
public class Solution307 {
    // 我这个方法和线段树完全没关系。。效率一般
    int[] nums;
    public Solution307(int[] nums) {
        this.nums = nums;
    }

    public void update(int i, int val) {
        nums[i] = val;
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        for (;i<=j;i++){
            sum+=nums[i];
        }
        return sum;
    }
}
