package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Solution525
 * @Description 525. 连续数组
 * @Author shishi
 * @Date 2019/10/25 20:18
 **/
public class Solution525 {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int[] counts = new int[2 * n + 1];
        Arrays.fill(counts,-2);
        // 初试化，折线图中的原点
        // 也就是value为0第一次出现的下标在nums[0]之前，就初始化为-1.
        counts[n] = -1;
        int maxLen = 0;
        int value = 0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]==0)
                value -= 1;
            else
                value += 1;

            // 说明不是第一次出现，那么就需要对比
            if (counts[value+n]>-2){
                maxLen = Math.max(maxLen,i-counts[value+n]);
            }
            else
                counts[value+n] = i;
        }

        return maxLen;
    }

    public int findMaxLength2(int[] nums){
        Map<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0,-1);
        int maxLen = 0;
        int value = 0;
        for (int i=0;i<nums.length;i++){
            value = value + (nums[i]==1?1:-1);

            if (hashMap.containsKey(value)){
                maxLen = Math.max(maxLen,i-hashMap.get(value));
            }
            else {
                hashMap.put(value,i);
            }
        }
        return maxLen;
    }
}
