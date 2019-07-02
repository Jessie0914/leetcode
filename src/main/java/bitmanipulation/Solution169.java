package bitmanipulation;

/**
 * @ClassName Solution169
 * @Description 169.求众数
 * @Author shishi
 * @Date 2019/6/27 13:55
 **/

/**
 * 题目要求：
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 *
 * 示例：
 * 输入: [3,2,3]
 * 输出: 3
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */

import java.util.Arrays;
import java.util.HashMap;

public class Solution169 {
    /**
     * 还是和136题目一样，用hashMap实现
     */
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums){
            Integer count = hashMap.get(num);
            if (count==null){
                count = 1;
                hashMap.put(num,count);
            }
            else {
                hashMap.put(num,count+1);
            }
        }

        int result = 0;
        int maxCount = Integer.MIN_VALUE;
        for (Integer i : hashMap.keySet()){
            if (hashMap.get(i)>maxCount){
                result = i;
                maxCount = hashMap.get(i);
            }
        }
        return result;
    }

    /**
     * 简单很多的一种算法：当排好序以后，众数一定是下标为floor(n/2)的值
     */
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    /**
     * Boyer-Moore 投票算法
     * 如果我们把众数记为 +1+1 ，把其他数记为 -1−1 ，将它们全部加起来，显然和大于 0 ，从结果本身我们可以看出众数比其他数多。
     */
    public int majorityElement3(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
