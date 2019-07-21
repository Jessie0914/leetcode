package sort.bucketsort;

/**
 * @ClassName Solution41
 * @Description 41.缺失的第一个正数
 * @Author shishi
 * @Date 2019/7/13 16:36
 **/

/**
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数
 *
 * 示例：
 * 输入: [1,2,0]
 * 输出: 3
 *
 * 输入: [3,4,-1,1]
 * 输出: 2
 *
 * 输入: [7,8,9,11,12]
 * 输出: 1
 */
public class Solution41 {
    // 参考41题题解中的第二个回答
    public int firstMissingPositive(int[] nums) {
        bucket_sort(nums);
        for (int i = 0; i < nums.length; ++i)
            // 找到第一个“没有存放在合适位置”的项
            if (nums[i] != (i + 1))
                return i + 1;
        return nums.length + 1;
    }

    // 桶排序，为了将所有的数放在“合适”的位置
    // 即数据2应该存放在下标为1的位置，5应该存放在下标为4的位置
    private static void bucket_sort(int[] A) {
        final int n = A.length;
        for (int i = 0; i < n; i++) {
            while (A[i] != i + 1) {
                // 小于0和大于数组长度的元素都是“捣乱项”，可以不用管
                if (A[i] < 1 || A[i] > n || A[i] == A[A[i] - 1])
                    break;
                // swap
                int tmp = A[i];
                A[i] = A[tmp - 1];
                A[tmp - 1] = tmp;
            }
        }
    }
}
