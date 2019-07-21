package search;

/**
 * @ClassName Solution154
 * @Description 154.搜索旋转排序数组的最小值2
 * @Author shishi
 * @Date 2019/7/13 20:30
 **/

import java.util.Arrays;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 请找出其中最小的元素。
 * 注意数组中可能存在重复的元素。
 */
public class Solution154 {
    // 正确思路：
    // 同151题目类似，要判断“断层”在左边还是右边。
    // 若 A[mid] < A[right] ，则区间 [mid,right] 一定递增，断层一定在左边
    // 若 A[mid] > A[right] ，则区间 [left,mid] 一定递增，断层一定在右边
    // 若 A[mid] == A[right] 确定不了，这个时候，断层既可能在左边，也可能在右边，所以我们不能扔掉一半，不过这时，我们可以 --right 扔掉一个
    public int findMin(int[] nums) {
        Arrays.sort(nums);
        return nums[0];
    }
}
