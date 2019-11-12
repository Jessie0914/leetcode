package String;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 重构字符串—第三个版本
 * @author: shishi
 * @create: 2019-09-09 12:07
 **/

public class Solution767_3 {
    public String reorganizeString(String S) {
        int length = S.length();
        // 建立一个26个英文字母的数组，值为对应字母的个数
        int[] nums = new int[26];
        Arrays.fill(nums,0);
        for (int i=0;i<S.length();i++){
            char c = S.charAt(i);
            nums[c-'a']++;
        }
        // 找到最大的那个值
        int max = Integer.MIN_VALUE;
        for (int i=0;i<26;i++){
            if (nums[i]>max){
                max = nums[i];
            }
        }
        boolean flag = true;
        if (max>(length+1)/2){
            flag = false;
        }

        int even = 0;
        int odd = 1;
        char[] result = new char[length];
        if (!flag){
            return "";
        }
        else {
            for (int i=0;i<26;i++){
                // 如果当前元素的个数小于一半的话，就把它放在奇数位
                while (nums[i]>0 && nums[i]<length/2+1 && odd<length){
                    result[odd] = (char) (i+'a');
                    nums[i]--;
                    odd+=2;
                }
                // 如果当前元素超过一半存放在偶数为
                // 如果当前元素也小于一半，但是奇数位已经越界了，就也放在偶数位
                while (nums[i]>0&&even<length){
                    result[even] = (char)(i+'a');
                    nums[i]--;
                    even+=2;
                }
            }
            return String.valueOf(result);
        }
    }
}
