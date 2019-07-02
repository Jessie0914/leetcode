package array;

/**
 * @ClassName Solution18
 * @Description 18.四数之和
 * @Author shishi
 * @Date 2019/6/30 14:23
 **/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目要求：
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target
 * 判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？
 * 找出所有满足条件且不重复的四元组。
 *
 * 示例：
 * 给定nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 */
public class Solution18 {
    // 也是参考15题
    // 我提交的时间用了94ms，第一名是4ms……太强了，可以去看一下的他的代码，也很简洁明了
    // 主要是他提前判断了很多情况，善于利用break和continue，其他都差不多
    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> lists = new ArrayList<>();

        if (nums.length <4) return lists;

        Arrays.sort(nums);

        for (int i=0;i<nums.length-3;++i){
            if (i>0 && nums[i]==nums[i-1]) continue;
            int j=i+1;
            while (j<nums.length-2){
                int k=j+1;
                int l = nums.length-1;
                while (k<l){
                    int sum = nums[i]+nums[j]+nums[k]+nums[l];
                    if (sum==target){
                        lists.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                        ++k;
                        --l;
                        while (k<l && nums[k]==nums[k-1]) ++k;
                        while (k<l && nums[l]==nums[l+1]) --l;
                    }
                    else if (sum>target){
                        --l;
                        while (k<l && nums[l]==nums[l+1]) --l;
                    }
                    else {
                        ++k;
                        while (k<l && nums[k]==nums[k-1]) ++k;
                    }
                }
                ++j;
                while (j<nums.length-2 && nums[j]==nums[j-1]) ++j;
            }
        }
        return lists;
    }
}
