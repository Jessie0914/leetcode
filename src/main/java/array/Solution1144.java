package array;

/**
 * @ClassName Solution1144
 * @Description 1144. 递减元素使数组呈锯齿状
 * @Author shishi
 * @Date 2019/9/30 14:50
 **/

import java.util.Arrays;

/**
 * 给你一个整数数组 nums，每次 操作 会从中选择一个元素并 将该元素的值减少 1。
 * ①每个偶数索引对应的元素都大于相邻的元素，即 A[0] > A[1] < A[2] > A[3] < A[4] > ...
 * ②或者，每个奇数索引对应的元素都大于相邻的元素，即 A[0] < A[1] > A[2] < A[3] > A[4] < ...
 */
public class Solution1144 {
    public int movesToMakeZigzag(int[] nums) {
        if (nums.length <=1) return 0;

        int length = nums.length;
        // 因为我是分成两种方案做，最后比较哪一种方案小的，而每一种方案都会改变原始数组，所以我先拷贝了一份，给第二种方案用
        int[] nums1;
        nums1 = Arrays.copyOf(nums,length);

        // 第一种方案，即每个偶数索引的都大于相邻的元素
        // 遍历数组的偶数索引，如果左右的大于当前的偶数索引值，就--，最后记得把--后的值替换到原值
        int evenCount = 0;
        int i=0;
        while (i<length){
            int num = nums[i];
            // 判断num是否都大于左右相邻的值
            // 判断左边的是否大于等于当前偶数索引值
            if (i-1>=0&&i-1<length){
                int numLeft = nums[i - 1];
                while (numLeft>=num){
                    evenCount++;
                    numLeft--;
                }
                nums[i-1] = numLeft;
            }
            // 判断右边的是否大于等于当前偶数索引值
            if (i+1>=0&&i+1<nums.length){
                int numRight = nums[i + 1];
                while (numRight>=num){
                    evenCount++;
                    numRight--;
                }
                nums[i+1] = numRight;
            }
            i+=2;
        }

        // 第二种方案，即每个奇数索引的都大于相邻的元素
        // 同第一种方案
        int oddCount = 0;
        // 从奇数索引开始遍历
        int j=1;
        while (j<length){
            int num = nums1[j];
            // 如果左边的值是否大于等于当前奇数索引的元素
            if (j-1>=0&&j-1<length){
                int numLeft = nums1[j-1];
                while (numLeft>=num){
                    oddCount++;
                    numLeft--;
                }
                nums1[j-1] = numLeft;
            }
            // 如果右边的值是否大于等于当前奇数索引的元素
            if (j+1>=0&&j+1<nums.length){
                int numRight = nums1[j+1];
                while (numRight>=num){
                    oddCount++;
                    numRight--;
                }
                nums1[j+1] = numRight;
            }
            j+=2;
        }

        // 返回两种方案中的操作次数小的那个
        return Math.min(evenCount,oddCount);
    }
}
