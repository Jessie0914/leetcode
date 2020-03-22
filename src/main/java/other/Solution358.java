package other; /**
 * @ClassName Solution358
 * @Description 350.两个数组的交集
 * @Author shishi
 * @Date 2019/7/23 17:12
 **/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 */
public class Solution358 {
    // 用到了hashmap，但我一开始竟然还分成了大的数组和小的数组
    // 其实没必要啊……先把小的数组放到hashmap中也可以啊，不影响结果（后来也没改）
    public int[] intersect(int[] nums1, int[] nums2) {
        int maxLen = nums1.length>=nums2.length? nums1.length : nums2.length;
        int minLen = nums1.length<nums2.length? nums1.length : nums2.length;
        int[] maxArray = new int[maxLen];
        int[] minArray = new int[minLen];
        if (nums1.length==maxLen){
            maxArray = nums1;
            minArray = nums2;
        }else {
            maxArray = nums2;
            minArray = nums1;
        }

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i=0;i<maxArray.length;i++){
            Integer integer = hashMap.get(maxArray[i]);
            if (integer==null){
                hashMap.put(maxArray[i],1);
            }else {
                hashMap.put(maxArray[i],integer+1);
            }
        }

        List<Integer> result = new ArrayList();
        for (int i=0;i<minArray.length;i++){
            Integer integer = hashMap.get(minArray[i]);
            if (integer!=null && integer!=0){
                result.add(minArray[i]);
                hashMap.put(minArray[i],integer-1);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
