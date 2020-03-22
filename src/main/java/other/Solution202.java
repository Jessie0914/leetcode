package other; /**
 * @program: leetcode
 * @description: 202.快乐数
 * @author: shishi
 * @create: 2019-07-21 16:38
 **/

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.HashMap;

/**
 * 题目要求：
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。
 * 如果可以变为 1，那么这个数就是快乐数。
 *
 * 示例：
 * 输入: 19
 * 输出: true
 */
public class Solution202 {
    HashMap<Integer, Boolean> hashMap = new HashMap<>();
    // 发现一个规律，快乐数最终会变成1
    // 如果不是快乐数，它某一次的中间结果一定会和前面的某一次重复
    // 所以我用一个hashmap保存所有的中间结果，每次结算到一个中间结果就先去hashmap中找有没有这个数，如果找到了，就说明不是快乐数
    public boolean isHappy(int n) {
        if (n==1) return true;
        while (n!=1){
            char[] chars = String.valueOf(n).toCharArray();
            int sum = 0;
            for (int i=0;i<chars.length;i++){
                int cur = chars[i]-'0';
                sum += Math.pow(cur,2);
            }

            if (hashMap.get(sum)==null){
                hashMap.put(sum,true);
                n = sum;
            }else {
                return false;
            }
        }
        return true;
    }
}
