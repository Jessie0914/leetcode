package array;

import java.util.*;

/**
 * @ClassName Solution448
 * @Description 448. 找到所有数组中消失的数字
 * @Author shishi
 * @Date 2019/9/16 21:16
 **/

/**
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * 输入:
 * [4,3,2,7,8,2,3,1]
 * 输出:
 * [5,6]
 */
public class Solution448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        // 建立一个hashSet，先将从1-n的数据都往里塞
        Set<Integer> hashSet = new HashSet<>();
        for (int i=1;i<=nums.length;i++){
            hashSet.add(i);
        }
        // 然后遍历数组，碰到一个出现的元素，就把hashSet中删除那个元素
        // 到最后hashSet中剩下的就是没有出现过的元素
        for (int i=0;i<nums.length;i++){
            if (hashSet.contains(nums[i])){
                hashSet.remove(nums[i]);
            }
        }
        // 最后遍历hashSet，将set中的所有元素都添加到list，返回即可
        Iterator<Integer> iterator = hashSet.iterator();
        while (iterator.hasNext()){
            list.add(iterator.next());
        }
        return list;
    }
}
