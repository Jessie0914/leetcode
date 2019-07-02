package heap;

/**
 * @ClassName Solution703
 * @Description 703.数据流中的第K大元素
 * @Author shishi
 * @Date 2019/6/25 19:32
 **/

import java.util.Arrays;

/**
 * 题目要求：
 * 设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
 * 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。
 * 每次调用 KthLargest.add，返回当前数据流中第K大的元素。
 *
 * 示例：
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5
 * kthLargest.add(9);   // returns 8
 * kthLargest.add(4);   // returns 8
 */

/**
 * 我这里的方法就是维持一个大小为k的ksizeNums数组，每次添加新的数组都重新排一下序，再截成k大小的数组
 * 第k大的元素就是ksizeNums的第一个元素
 * 通过了9个测试用例，最后一个超时了。。。。。。
 * 后来在add函数中加了一个判断语句，如果要add的数本身比ksizeNums[0]小的话，就直接return ksizeNums[0]即可
 */
public class Solution703 {
    int[] ksizeNums;
    int size = 0;

    // 初始化就会返回一个排好序的大小为k的数组
    public Solution703(int k, int[] nums) {
        this.ksizeNums = new int[k];
        this.size = k;
        // 这里要注意nums.length == k-1的情况，不判断的话会导致数组越界问题
        // 我这里的方法就是扩大一个容量，填充一个int的最小值
        if (nums.length == k-1){
            nums = Arrays.copyOf(nums, nums.length + 1);
            nums[k-1] = Integer.MIN_VALUE;
        }
        Arrays.sort(nums);
        ksizeNums = Arrays.copyOfRange(nums,nums.length-k,nums.length);
    }

    // 每次调用这个函数就都会返回当前第K大的元素
    public int add(int val) {
        // 加了下面这一段就没不超时了，但效率仍然是非常的低。。
        if (val<ksizeNums[0]){
            return ksizeNums[0];
        }
        ksizeNums = Arrays.copyOf(ksizeNums,size+1);
        ksizeNums[size] = val;
        Arrays.sort(ksizeNums);

        // 再取ｋ大小的数组
        ksizeNums = Arrays.copyOfRange(this.ksizeNums, this.ksizeNums.length - size, this.ksizeNums.length);
        return ksizeNums[0];
    }
}
