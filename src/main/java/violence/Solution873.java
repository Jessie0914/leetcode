package violence;

/**
 * @program: leetcode
 * @description: 873. 最长的斐波那契子序列的长度
 * @author: shishi
 * @create: 2019-11-12 14:11
 **/

import java.util.HashMap;
import java.util.Map;

/**
 * 输入: [1,2,3,4,5,6,7,8]
 * 输出: 5
 * 解释:
 * 最长的斐波那契式子序列为：[1,2,3,5,8] 。
 *
 * 输入: [1,3,7,11,12,14,18]
 * 输出: 3
 * 解释:
 * 最长的斐波那契式子序列有：
 * [1,11,12]，[3,11,14] 以及 [7,11,18] 。
 */
public class Solution873 {
    public int lenLongestFibSubseq(int[] A) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        int len = A.length;
        for (int i=0;i<len;i++){
            hashMap.put(A[i],i);
        }

        int maxLen = 0;
        // 开始暴力遍历
        // 第一个数的范围
        for (int i=0;i<len-2;i++){
            int firstNum = A[i];
            // 第二个数的范围
            for (int j=i+1;j<=len-maxLen&&j<len-1;j++){
                int secondNum = A[j];
                int curLen = 2;

                int temp = secondNum;
                int thirdNum = firstNum+secondNum;
                // 判断hashMap中有没有thirdNum
                while (hashMap.containsKey(thirdNum)){
                    curLen++;
                    int newThirdNum = thirdNum + temp;
                    temp = thirdNum;
                    thirdNum = newThirdNum;
                }

                // 更新maxLen
                if (curLen>maxLen){
                    maxLen = curLen;
                }
            }
        }

        if (maxLen<3){
            return 0;
        }else {
            return maxLen;
        }
    }
}
