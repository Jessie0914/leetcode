package String;

/**
 * @program: leetcode
 * @description: 重构字符串—第二种思路
 * @author: shishi
 * @create: 2019-09-09 11:20
 **/

import java.util.*;

/**
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 *
 * 输入: S = "aab"  输出: "aba"
 *
 * 输入: S = "aaab"  输出: ""
 */
public class Solution767_2 {
    // 思路还是错的（很绝望），脑子不够，不过这一版距离可行差不多了，再写一版本
    public String reorganizeString(String S) {
        int length = S.length();
        if (length==0 || length==1) return S;
        else if (length==2){
            if (S.charAt(0)==S.charAt(1)) return "";
            else return S;
        }

        char[] chars = S.toCharArray();
        Map<Character, Integer> hashMap = new HashMap<>();
        // 遍历数组，存入到hashMap中
        for (int i=0;i<chars.length;i++) {
            char c = chars[i];
            if (hashMap.containsKey(c)){
                int num = hashMap.get(c);
                num = num+1;
                hashMap.put(c,num);
            }else {
                hashMap.put(c,1);
            }
        }

        boolean flag = true;
        // 找hashmap中最大的,先将value从大到小排列
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(hashMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                int value1 = o1.getValue();
                int value2 = o2.getValue();
                return value2-value1;
            }
        });
        if (list.size()<2) return "";
        Map.Entry<Character, Integer> entry1 = list.get(0);
        Map.Entry<Character, Integer> entry2 = list.get(1);
        int max1 = entry1.getValue();
        int max2 = entry2.getValue();
        int minus = max1-max2;
        if (minus>1) flag = false;
        else flag = true;

        // 如果flag为false直接return
        if (!flag) return "";
        else {
            StringBuilder stringBuilder = new StringBuilder();
            int index = 0;
            while (index<length){
                Iterator<Character> iterator = hashMap.keySet().iterator();
                while (iterator.hasNext()&&index<length){
                    char c = iterator.next();
                    int num = hashMap.get(c);
                    if (num>0){
                        num--;
                        hashMap.put(c,num);
                        stringBuilder.append(c);
                        index++;
                    }
                }
            }
            return stringBuilder.toString();
        }
    }
}
