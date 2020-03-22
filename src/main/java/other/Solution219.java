package other; /**
 * @ClassName Solution219
 * @Description 219.存在重复元素2
 * @Author shishi
 * @Date 2019/7/22 13:44
 **/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
 * 使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 */
public class Solution219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if (hashMap.get(nums[i])==null){
                List<Integer> list = new ArrayList<>();
                list.add(i);
                hashMap.put(nums[i],list);
            }else {
                List<Integer> list = hashMap.get(nums[i]);
                for (int j=0;j<list.size();j++){
                    if (Math.abs(i-list.get(j))<=k) return true;
                }
                list.add(i);
            }
        }
        return false;
    }
}
