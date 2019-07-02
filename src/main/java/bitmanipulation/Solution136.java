package bitmanipulation;

/**
 * @ClassName Solution136
 * @Description 136.只出现一次的数字
 * @Author shishi
 * @Date 2019/6/27 11:13
 **/

import java.util.*;

/**
 * 题目要求：
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 你的算法应该具有线性时间复杂度。你可以不使用额外空间来实现吗？
 *
 * 示例：
 * 输入: [2,2,1]
 * 输出: 1
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */

/**
 * 第一反应是用hashMap，但对hash表有点不熟悉，但这个方法肯定比暴力求解法要好
 * hashMap.get(key)
 * hashMap.put(key,value)
 * hashMap.keySet()是获取hashMap所有的key，可以用于遍历
 */
public class Solution136 {
    /**
     * 用hashmap第一遍遍历的时候，把对应数值装进去，最后再遍历hashmap即可，找到value为1的就可以
     */
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> hashMap= new HashMap<>();
        for (int num : nums){
            Integer count = hashMap.get(num);
            if (count==null){
                hashMap.put(num,1);
            }else {
                hashMap.put(num,count+1);
            }
        }

        for (int i : hashMap.keySet()){
            Integer count = hashMap.get(i);
            if (count==1){
                return i;
            }
        }
        return -1;
    }

    /**
     * 真正满足题目要求的方法，没有用额外的空间
     * 用的是异或的思想，1^1 = 0, 1^0 = 1
     * 所以题目里面说所有的数值，只有一个数字是出现一次，其他数字都是出现两次，相同的数字异或为0
     * 那么将所有的数值都做一遍异或操作，最终得到的值就是那个只出现过一次的数字
     * （神级操作）
     */
    public int singleNumber2(int[] nums){
        int ans = nums[0];
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                ans = ans ^ nums[i];
            }
        }
        return ans;
    }



}
