package other;

import java.util.HashMap;

/**
 * @ClassName Solution389
 * @Description 389.找不同
 * @Author shishi
 * @Date 2019/7/18 20:50
 **/
public class Solution389 {
    public char findTheDifference(String s, String t) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char c : s.toCharArray()){
            if (hashMap.get(c)==null){
                hashMap.put(c,1);
            }else {
                hashMap.put(c,hashMap.get(c)+1);
            }
        }
        for (char c : t.toCharArray()){
            if (hashMap.get(c)==null){
                return c;
            }
            else {
                hashMap.put(c,hashMap.get(c)-1);
            }
        }

        for (Character key : hashMap.keySet()){
            if (hashMap.get(key)!=0){
                return key;
            }
        }
        return 0;
    }

    // 有一种很巧妙的方法
    // 利用异或计算，因为只有一个字母，所以将s和t所有的字母都做异或操作之后，剩下的那个字母就是结果
    public char findTheDifference2(String s, String t) {
        char ans = t.charAt(t.length()-1);
        for (int i=0;i<s.length();i++){
            ans ^= s.charAt(i);
            ans ^=t.charAt(i);
        }
        return ans;
    }
}
