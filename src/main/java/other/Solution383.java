package other; /**
 * @ClassName Solution383
 * @Description 383.赎金信
 * @Author shishi
 * @Date 2019/7/19 10:31
 **/

import java.util.HashMap;

/**
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，
 * 判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。
 * 如果可以构成，返回 true ；否则返回 false。
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */
public class Solution383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] char1 = magazine.toCharArray();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i=0;i<char1.length;i++){
            if (hashMap.get(char1[i])==null){
                hashMap.put(char1[i],1);
            }else {
                hashMap.put(char1[i],hashMap.get(char1[i])+1);
            }
        }

        char[] char2 = ransomNote.toCharArray();
        for (int i=0;i<char2.length;i++){
            if (hashMap.get(char2[i])==null || hashMap.get(char2[i])<1){
                return false;
            }else {
                hashMap.put(char2[i],hashMap.get(char2[i])-1);
            }
        }
        return true;
    }
}
