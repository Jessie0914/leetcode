package sort;

import sun.security.krb5.internal.crypto.HmacSha1Aes128CksumType;

import java.awt.event.FocusEvent;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @ClassName Solution242
 * @Description 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * @Author shishi
 * @Date 2019/6/25 15:41
 **/

/**
 * 示例：
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 */

/**
 * 我想到的方法就是利用一个size为26的hashmap，初始化成都为0
 * 遍历第一个字符串的时候，将所在字符对应的数值++
 * 然后再遍历第二个字符串，将所在字符对应的数值--
 * 如果是字母异位词的话，应该最后hashmap的值都为0
 * 但这个方法比较低效，消耗的内存和时间都比较多
 */
public class Solution242 {

    HashMap<Integer, Integer> hashMap;

    public Solution242(){
        this.hashMap = new HashMap<>();
        for (int i=0;i<26;i++){
            hashMap.put(i,0);
        }
    }

    public boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()){
            return false;
        }
        // 将第一个字符串里面的字符取出来，放到对应的hashmap中
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            int numInt = hashMap.get(c - 'a').intValue();
            numInt++;
            Integer numInteger =numInt;
            hashMap.put(c-'a',numInteger);
        }

        // 再比较第二个字符串，遇到一样的字符串，就数量--
        for (int i=0;i<t.length();i++){
            char c = t.charAt(i);
            int numInt = hashMap.get(c - 'a').intValue();
            numInt--;
            Integer numInteger = numInt;
            hashMap.put(c-'a',numInteger);
        }

        // 最后判断这个hashmap是不是为全0
        for (int i=0;i<26;i++){
            int value = hashMap.get(i).intValue();
            if (value!=0){
                return false;
            }
        }
        return true;
    }
}
