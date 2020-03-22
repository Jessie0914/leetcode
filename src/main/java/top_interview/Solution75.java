package top_interview;

/**
 * @ClassName Solution75
 * @Description 颜色分类
 * @Author shishi
 * @Date 2020/3/9 14:43
 **/

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 */
public class Solution75 {
    // 荷兰国旗问题
    // 维护三个指针
    // po代表0的最右边界,p2代表2的最左边界,cur代表当前指针
    // 当cur>p2的时候，就说明一切已经就绪
    public void sortColors(int[] nums) {
        int p0 = 0;
        int cur = 0;
        int p2 = nums.length - 1;
        while (cur <= p2) {
            // 如果为2，则只交换
            if (nums[cur] == 2) {
                swap(nums, cur, p2);
                p2--;
            }
            // 如果为0，则交换且cur++
            else if (nums[cur] == 0) {
                swap(nums, cur, p0);
                p0++;
                cur++;
            }
            // 如果为1，则只cur++
            else
                cur++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
