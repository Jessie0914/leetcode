/**
 * @ClassName Solution167
 * @Description 167.两数之和2-输入有序数组
 * @Author shishi
 * @Date 2019/7/20 18:04
 **/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2
 *
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 */
public class Solution167 {
    // 自己用了hash表的方法，没有利用数组已经排好序的性质，leetcode官方题解的巧妙的方法如下（双指针）
    // 我们使用两个指针，初始分别位于第一个元素和最后一个元素位置，比较这两个元素之和与目标值的大小。
    // 如果和等于目标值，我们发现了这个唯一解。如果比目标值小，我们将较小元素指针增加一。
    // 如果比目标值大，我们将较大指针减小一。
    // 移动指针后重复上述比较知道找到答案。

    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        // 这里需要注意的点是数组可能有重复的值，所以hashmap的value应该是一个list，存放相同数值的下标
        for (int i=0;i<numbers.length;i++){
            List<Integer> list1 = hashMap.get(numbers[i]);
            if (list1!=null){
                list1.add(i+1);
                hashMap.put(numbers[i],list1);
            }else {
                ArrayList<Integer> list2 = new ArrayList<>();
                list2.add(i+1);
                hashMap.put(numbers[i],list2);
            }
        }
        Set<Integer> keySet = hashMap.keySet();
        for (int i=0;i<numbers.length;i++){
            if (keySet.contains(target-numbers[i])){
                List<Integer> list = hashMap.get(numbers[i]);
                if (list.size()>1){
                    return new int[]{list.get(0),list.get(1)};
                }
                else {
                    return new int[]{hashMap.get(numbers[i]).get(0),hashMap.get(target-numbers[i]).get(0)};
                }
            }

        }
        return null;
    }
}
