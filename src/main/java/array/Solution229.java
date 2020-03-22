package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Solution229
 * @Description 229. 求众数II
 * @Author shishi
 * @Date 2019/10/20 16:56
 **/

/**
 * 给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 * <p>
 * 输入: [3,2,3]
 * 输出: [3]
 * <p>
 * 输入: [1,1,1,3,3,2,2,2]
 * 输出: [1,2]
 */
public class Solution229 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int len = (int) Math.floor(nums.length / 3);
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length) {
            int num = nums[i];
            int count = 1;
            while (i + 1 < nums.length && nums[i + 1] == num) {
                count++;
                i++;
            }
            if (count > len) {
                list.add(num);
            }
            i++;
        }
        return list;
    }
}
