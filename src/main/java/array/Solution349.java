package array;
/**
 * @ClassName array.Solution349
 * @Description 349.两个数组的交集
 * @Author shishi
 * @Date 2019/7/1 21:18
 **/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;

/**
 * 题目要求：
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例：
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 */
public class Solution349 {
    // 我是把nums1的数字都装入了一个hashmap，并在遍历nums2的时候，检查存不存在，如果存在的话，就加入结果数组
    // 但这会造成一个问题，就是有重复的元素，所以我再用一个hashmap，遍历nums2的时候，装入新的hashmap，只有当新的hashmap的值为1的时候，加入结果数组
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] result = new int[Math.max(nums1.length,nums2.length)];
        int index = 0;
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        Hashtable<Integer, Integer> hashtable1 = new Hashtable<>();
        for (int i=0;i<nums1.length;i++){
            if (hashtable.get(nums1[i])==null){
                hashtable.put(nums1[i],1);
            }else {
                hashtable.put(nums1[i],hashtable.get(nums1[i])+1);
            }
        }
        for (int j=0;j<nums2.length;j++){
            if (hashtable.get(nums2[j])!=null){
                if (hashtable1.get(nums2[j])==null){
                    hashtable1.put(nums2[j],1);
                }else {
                    hashtable1.put(nums2[j],hashtable1.get(nums2[j])+1);
                }
                if (hashtable1.get(nums2[j])==1){
                    result[index++] = nums2[j];
                }
            }
        }
        return Arrays.copyOfRange(result,0,index);
    }

    // 用到的是set，set集合的性质就是没有重复的元素，所以先可以将nums数组转换成两个set
    // 然后遍历set1集合，如果在set2中找到了，就加入结果数组
    public void toSet(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        for (int i:nums1){
            set1.add(i);
        }
        HashSet<Integer> set2 = new HashSet<>();
        for (int i:nums2){
            set2.add(i);
        }
    }
}
