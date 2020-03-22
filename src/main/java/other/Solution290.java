package other; /**
 * @ClassName Solution290
 * @Description 290.单词规律
 * @Author shishi
 * @Date 2019/7/22 9:58
 **/


import java.util.*;

/**
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 */
public class Solution290 {
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character, List<Integer>> hashMap = new HashMap<>();
        for (int i=0;i<pattern.length();i++){
            char c = pattern.charAt(i);
            if (hashMap.get(c)==null){
                List<Integer> list = new ArrayList<>();
                list.add(i);
                hashMap.put(c,list);
            }else {
                List<Integer> list = hashMap.get(c);
                list.add(i);
                hashMap.put(c,list);
            }
        }

        String[] s = str.split(" ");
        if (s.length<pattern.length()) return false;

        String[] validDuplicate = new String[hashMap.size()];
        int index = 0;

        Iterator<Character> iterator = hashMap.keySet().iterator();
        while (iterator.hasNext()){
            Character c = iterator.next();
            List<Integer> list = hashMap.get(c);
            int compareIndex = list.get(0);
            String s1 = s[compareIndex];
            validDuplicate[index++] = s1;
            if (list.size()==1) continue;
            else {
                for (int i=1;i<list.size();i++){
                    String s2 = s[list.get(i)];
                    if (!s1.equals(s2)) return false;
                }
            }
        }

        // 验证validDuplicate数组里面有没有重复的元素
        HashMap<String, Integer> VaildMap = new HashMap<>();
        for (int i=0;i<validDuplicate.length;i++){
            if (VaildMap.get(validDuplicate[i])==null){
                VaildMap.put(validDuplicate[i],1);
            }else {
                return false;
            }
        }

        return true;
    }

    // 算法群里的题解，用的是hashmap和set
    public boolean wordPattern2(String pattern, String str) {
        char[] chars = pattern.toCharArray();
        String[] s = str.split(" ");
        if(chars.length != s.length) {
            return false;
        }
        //存储pattern->str对应键值对
        HashMap<Character, String> map = new HashMap<>();
        //存储str不重复的value
        Set<String> set = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            String s1 = map.get(chars[i]);
            if(s1==null){
                // 这里可以杜绝"aaab"->"cat cat cat cat"的情况
                // 意思就是如果当map中不存在b的映射，但是set中却已经有当前s[i],即cat了的时候也是return false;
                if(!set.contains(s[i])){
                    set.add(s[i]);
                    map.put(chars[i],s[i]);
                }else{
                    return false;
                }
            }else{
                //如果遇到不相等的值
                if(!s1.equals(s[i])){
                    return false;
                }
            }
        }
        return true;
    }
}
