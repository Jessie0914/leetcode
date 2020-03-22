package other; /**
 * @ClassName Solution9
 * @Description 9.回文数
 * @Author shishi
 * @Date 2019/6/28 15:24
 **/

import java.util.ArrayList;
import java.util.List;

/**
 * 题目要求：
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例：
 * 输入: 121
 * 输出: true
 *
 * 输入: -121
 * 输出: false
 *
 * 输入: 10
 * 输出: false
 */
public class Solution9 {
    // 这个方法最直观，但是比较浪费空间，需要额外的数组
    // 还有一种方法是只反转后一半的数字，如果后一半反转过后与前一半相同，那么就是回文字符串
    public boolean isPalindrome(int x) {
        if (x<0) return false;
        if (x==0) return true;
        List<Integer> list = new ArrayList<>();
        while (x!=0){
            list.add(x%10);
            x/=10;
        }
        int length = list.size();
        for (int i=0;i<length/2;i++){
            if (list.get(i)!=list.get(length-1-i)){
                return false;
            }
        }
        return true;
    }
}
