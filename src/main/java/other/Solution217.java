package other; /**
 * @ClassName Solution217
 * @Description 217.存在重复元素
 * @Author shishi
 * @Date 2019/7/22 13:35
 **/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 */
public class Solution217 {
    // 用哈希表set解决
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i=0;i<nums.length;i++){
            if (!set.contains(nums[i])){
                set.add(nums[i]);
            }else {
                return true;
            }
        }
        return false;
    }

    // 先排序，然后一个一个比较的效率比哈希表高很多
    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i=0;i<nums.length-1;i++){
            if (nums[i]==nums[i+1]) return true;
        }
        return false;
    }
}
