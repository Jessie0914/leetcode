package ali_leetcode_daily.bytedance;

/**
 * @ClassName Solution215
 * @Description 215. 数组中的第K个最大元素
 * @Author shishi
 * @Date 2020/7/26 14:26
 **/

import java.util.PriorityQueue;

/**
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 */
public class Solution215 {

    // 借助最小堆
    public int findKthLargest(int[] nums, int k) {
        // 维护一个最小堆
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            if (queue.size() < k) {
                queue.add(nums[i]);
            } else {
                if (nums[i] > queue.peek()) {
                    queue.poll();
                    queue.add(nums[i]);
                }
            }
        }
        return queue.peek();
    }

    // 利用快速排序的思想
    public int findKthLargest2(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;
        return findK(nums, 0, nums.length - 1, k);
    }

    private int findK(int[] nums, int i, int j, int k) {
        if (i >= j)
            return nums[i];

        int index = partition(nums, i, j);

        int numsOfRight = j - index + 1;

        if (k == numsOfRight)
            return nums[index];
        else if (numsOfRight > k) {
            return findK(nums, index + 1, j, k);
        } else
            return findK(nums, i, index - 1, k - numsOfRight);
    }

    private int partition(int[] nums, int i, int j) {
        if (i > j)
            return -1;

        int pivot = nums[i];

        while (i < j) {
            while (i < j && nums[j] >= pivot) {
                j--;
            }
            swap(nums, i, j);

            while (i < j && nums[i] < pivot) {
                i++;
            }
            swap(nums, i, j);
        }
        nums[i] = pivot;

        return i;
    }

    private void swap(int[] nums, int i, int j) {
        if (i > j)
            return;
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
